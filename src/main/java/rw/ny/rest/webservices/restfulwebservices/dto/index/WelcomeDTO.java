package rw.ny.rest.webservices.restfulwebservices.dto.index;

import java.util.Date;

public class WelcomeDTO {
    private String welcomeMessage;
    private final Date currentDate = new Date();

    public WelcomeDTO(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

}
