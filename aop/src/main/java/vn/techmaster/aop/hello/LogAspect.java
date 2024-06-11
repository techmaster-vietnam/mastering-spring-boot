package vn.techmaster.aop.hello;

public class LogAspect implements Aspect {

    @Override
    public void beforeMethod(String method) {
        System.out.println("before " + method);
    }

    @Override
    public void afterMethod(String method) {
        System.out.println("after " + method);
    }
}
