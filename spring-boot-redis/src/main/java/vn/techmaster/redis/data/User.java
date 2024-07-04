package vn.techmaster.redis.data;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@Setter
@ToString
@RedisHash("users")
public class User implements Serializable {
    @Id
    private String username;
    private String displayName;
}
