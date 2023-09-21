package rw.ny.rest.webservices.restfulwebservices.index.controllers;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rw.ny.rest.webservices.restfulwebservices.dto.index.WelcomeDTO;

import java.util.Locale;

@RestController
public class WelcomeController {

    private final MessageSource messageSource;

    public WelcomeController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/index")
    public WelcomeDTO welcomeToMicroservice() {
        Locale locale = LocaleContextHolder.getLocale();
        return new WelcomeDTO(messageSource.getMessage("good.morning.message", null, "Default Message", locale));
    }
}
