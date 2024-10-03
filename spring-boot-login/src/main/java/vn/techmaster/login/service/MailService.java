package vn.techmaster.login.service;

import org.springframework.stereotype.Service;

@Service
public class MailService {

    public void sendActivationEmail(
        String toUserEmail,
        String toUserDisplayName,
        String username,
        String activationToken
    ) {
    }
}
