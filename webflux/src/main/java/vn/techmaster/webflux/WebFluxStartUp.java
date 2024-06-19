package vn.techmaster.webflux;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.netty.http.server.HttpServer;

public class WebFluxStartUp {

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext =
            new AnnotationConfigApplicationContext(
                "vn.techmaster.webflux"
            );
        HttpHandler httpHandler = WebHttpHandlerBuilder
            .applicationContext(applicationContext)
            .build();
        HttpServer.create()
            .port(8080)
            .handle(new ReactorHttpHandlerAdapter(httpHandler))
            .bindNow()
            .onDispose()
            .block();
    }
}
