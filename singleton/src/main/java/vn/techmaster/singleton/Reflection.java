package vn.techmaster.singleton;

import vn.techmaster.singleton.controller.PaymentController;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

public class Reflection {

    public static void main(String[] args) {
        Constructor<?> constructor = PaymentController.class.getConstructors()[0];
        for (Parameter parameter : constructor.getParameters()) {
            System.out.println(parameter.getName());
        }
    }
}
