package rw.ny.rest.webservices.restfulwebservices.users;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class UserDAOService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("fabrice", LocalDate.now().minusYears(30)));
        users.add(new User("eric", LocalDate.now().minusYears(23)));
        users.add(new User("murenzi", LocalDate.now().minusYears(56)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(String id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User createUser(String name) {
        User newUser = new User(name, LocalDate.now().minusYears(new Random().nextInt((100 - 20) + 1) + 20));
        users.add(newUser);
        return newUser;
    }

    public void deleteOne(String id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
