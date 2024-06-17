package vn.techmaster.simple_module.entity;

import lombok.Data;

@Data
public class AccessToken {
    private String accessToken;
    private long userId;
}
