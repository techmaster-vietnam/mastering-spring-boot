package vn.techmaster.singleton.service;

import org.springframework.stereotype.Component;
import vn.techmaster.singleton.model.UserModel;

@Component
public class UserService {

    public UserModel getUserByUsername(String username) {
        return new UserModel(username);
    }
}
