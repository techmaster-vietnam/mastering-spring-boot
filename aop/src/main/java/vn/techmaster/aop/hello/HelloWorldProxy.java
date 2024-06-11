package vn.techmaster.aop.hello;

import java.util.List;

public class HelloWorldProxy extends HelloWorld {

    private final List<Aspect> aspects = List.of(
        new LogAspect()
    );

    private void beforeSayHello() {
        for (Aspect aspect : aspects) {
            aspect.beforeMethod("sayHello");
        }
    }

    @Override
    public void sayHello() {
        beforeSayHello();
        super.sayHello();
        afterSayHello();
    }

    private void afterSayHello() {
        for (Aspect aspect : aspects) {
            aspect.afterMethod("sayHello");
        }
    }
}
