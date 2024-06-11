package vn.techmaster.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import vn.techmaster.aop.controller.UserController;
import vn.techmaster.aop.performance.PerformanceManager;

import java.math.BigDecimal;

@Configuration
@ComponentScan(basePackages = "vn.techmaster.aop")
@EnableAspectJAutoProxy
public class AopStartUp {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(
                "vn.techmaster.aop"
            );
        UserController userController = applicationContext
            .getBean(UserController.class);
        userController.updateBalance(
            "Dzung",
            BigDecimal.ZERO
        );
        userController.updateProfile("Dzung", "dung@techmaster.vn");
        PerformanceManager performanceManager = applicationContext
            .getBean(PerformanceManager.class);
        System.out.println(performanceManager.getSummary());
    }
}
