package vn.techmaster.singleton.service;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TechmasterPaymentService implements PaymentService {

    @Override
    public void processUserPayment(
        String username,
        BigDecimal amount
    ) {
        System.out.println(
            "User pay via Techmaster, amount: " + amount
        );
    }
}
