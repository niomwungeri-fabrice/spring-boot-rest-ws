package rw.ny.rest.webservices.restfulwebservices.users;

import java.time.LocalDate;
import java.util.UUID;

public class User {
    private final String id = UUID.randomUUID().toString();
    private String name;
    private LocalDate dob;

    public User(String name, LocalDate dob) {
        this.name = name;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getId() {
        return id;
    }
}
