package vn.techmaster.login.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String email;

    private String password;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "activation_token")
    private String activationToken;

    @Enumerated(EnumType.STRING)
    private UserStatus status;
}

