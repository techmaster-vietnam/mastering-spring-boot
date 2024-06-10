package vn.techmaster.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vn.techmaster.singleton.controller.PaymentController;
import vn.techmaster.singleton.service.PaymentService;

public class SingletonStartUp {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(
                "vn.techmaster.singleton"
            );
        PaymentController paymentController = applicationContext
            .getBean(PaymentController.class);
        PaymentService paymentService = applicationContext
            .getBean("youngMonkeysPaymentService", PaymentService.class);
    }
}
