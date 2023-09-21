package rw.ny.rest.webservices.restfulwebservices.users;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rw.ny.rest.webservices.restfulwebservices.dto.users.UserRequestDTO;
import rw.ny.rest.webservices.restfulwebservices.exceptions.ResourceNotFoundException;

import java.net.URI;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
public class UserController {
    private final UserDAOService userDAOService;

    @Autowired
    public UserController(UserDAOService userDAOService) {
        this.userDAOService = userDAOService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDAOService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) throws ResourceNotFoundException {
        User user = userDAOService.findOne(id);
        if (user == null){
            throw new ResourceNotFoundException(String.format("User with >%s< does not exist", id));
        }
        return user;
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?>  deleteUser(@PathVariable String id) {
        userDAOService.deleteOne(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRequestDTO requestDTO) {
        User user = userDAOService.createUser(requestDTO.getName());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .build(user.getId());
        return ResponseEntity.created(location).body(user);
    }
}
