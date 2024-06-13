package vn.techmaster.webmvc.model;

import org.springframework.stereotype.Component;

@Component
public class MessageService {

    public String getMessage() {
        return "Welcome to Techmaster";
    }
}
