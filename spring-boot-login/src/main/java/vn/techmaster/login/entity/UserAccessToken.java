package vn.techmaster.login.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "access_tokens")
public class UserAccessToken {
    @Id
    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "expired_at")
    private LocalDateTime expiredAt;
}
