package rw.ny.rest.webservices.restfulwebservices.dto.users;

import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class UserRequestDTO implements Serializable {
    @Size(min=2, message = "name should have at least 2 characteristics")
    private String name;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
