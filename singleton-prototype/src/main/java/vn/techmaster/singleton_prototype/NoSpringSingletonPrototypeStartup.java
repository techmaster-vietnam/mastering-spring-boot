package vn.techmaster.singleton_prototype;

import vn.techmaster.singleton_prototype.data.Data;
import vn.techmaster.singleton_prototype.service.PrototypeService;
import vn.techmaster.singleton_prototype.service.SingletonService;

public class NoSpringSingletonPrototypeStartup {

    public static void main(String[] args) {
        SingletonService singletonService = new SingletonService();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; ++i) {
            singletonService.execute(new Data());
        }
        long end = System.currentTimeMillis();
        System.out.println("singleton elapsed time: " + (end - start));

        start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; ++i) {
            PrototypeService prototypeService = new PrototypeService();
            prototypeService.execute(new Data());
        }
        end = System.currentTimeMillis();
        System.out.println("prototype elapsed time: " + (end - start));
    }
}
