package vn.techmaster.singleton.controller;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import vn.techmaster.singleton.model.UserModel;
import vn.techmaster.singleton.service.PaymentService;
import vn.techmaster.singleton.service.UserService;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;

@Setter
@Controller
public class PaymentController {

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("techmasterPaymentService")
    private PaymentService paymentService;

    @Autowired
    private ExecutorService applicationExecutorService;

    public void handleUserPayment(
        String username,
        BigDecimal amount
    ) {
        UserModel user = userService.getUserByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("user not found");
        }
        applicationExecutorService.execute(() ->
            paymentService.processUserPayment(
                username,
                amount
            )
        );
    }
}
