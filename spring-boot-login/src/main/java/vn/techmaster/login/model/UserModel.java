package vn.techmaster.login.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import vn.techmaster.login.entity.UserStatus;

@Getter
@Builder
public class UserModel {
    private long id;
    private String username;
    private String email;
    private String password;
    private String displayName;
    private String activationToken;
    private UserStatus status;
}

