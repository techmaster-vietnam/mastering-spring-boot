package vn.techmaster.singleton.service;

import java.math.BigDecimal;

public interface PaymentService {

    void processUserPayment(
        String username,
        BigDecimal amount
    );
}
