package vn.techmaster.webflux.handler;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.HandlerAdapter;
import org.springframework.web.reactive.HandlerResult;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class WebFluxHandlerAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return true;
    }

    @Override
    public Mono<HandlerResult> handle(ServerWebExchange exchange, Object handler) {
        try {
            Function<ServerWebExchange, Object> func = (Function) handler;
            return Mono.just(
                new HandlerResult(
                    handler,
                    func.apply(exchange),
                    new MethodParameter(
                        Function.class.getDeclaredMethod(
                        "apply",
                            Object.class
                        ),
                        -1
                    )
                )
            );
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
