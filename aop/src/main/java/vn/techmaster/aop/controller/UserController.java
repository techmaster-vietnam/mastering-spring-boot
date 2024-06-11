package vn.techmaster.aop.controller;

import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

@Controller
public class UserController {

    public void updateProfile(
        String username,
        String data
    ) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBalance(
        String username,
        BigDecimal balance
    ) {
    }
}
