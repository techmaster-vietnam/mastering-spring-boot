package vn.techmaster.webflux.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import vn.techmaster.webflux.controller.HelloController;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class WebFluxHandlerMapping implements HandlerMapping {
    private final Map<String, Function<ServerWebExchange, Object>> handlerByUri;

    public WebFluxHandlerMapping(
        HelloController helloController
    ) {
        handlerByUri = new HashMap<>();
        handlerByUri.put("/", (exchange) ->
            helloController.index()
        );
        handlerByUri.put("/favicon.ico", (exchange) ->
            Mono.just("")
        );
    }

    @Override
    public Mono<Object> getHandler(ServerWebExchange exchange) {
        String uri = exchange.getRequest().getURI().getPath();
        return Mono.just(handlerByUri.get(uri));
    }
}
