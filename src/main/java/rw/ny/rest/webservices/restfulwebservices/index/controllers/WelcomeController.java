package rw.ny.rest.webservices.restfulwebservices.index.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.ny.rest.webservices.restfulwebservices.dto.index.WelcomeDTO;

@RestController
public class WelcomeController {
    @GetMapping("/index")
    public WelcomeDTO welcomeToMicroservice() {
        return new WelcomeDTO("Welcome to Spring microservices");
    }
}
