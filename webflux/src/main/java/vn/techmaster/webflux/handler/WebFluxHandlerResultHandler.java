package vn.techmaster.webflux.handler;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.HandlerResult;
import org.springframework.web.reactive.HandlerResultHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
public class WebFluxHandlerResultHandler implements HandlerResultHandler {

    private final DefaultDataBufferFactory dataBufferFactory =
        new DefaultDataBufferFactory();

    @Override
    public boolean supports(HandlerResult result) {
        return true;
    }

    @Override
    public Mono<Void> handleResult(ServerWebExchange exchange, HandlerResult result) {
        try {
            DataBuffer dataBuffer = dataBufferFactory.wrap(
                result
                    .getReturnValue()
                    .toString()
                    .getBytes(StandardCharsets.UTF_8)
            );
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.OK);
            response
                .getHeaders()
                .add("Content-Type", "text/html");
            return response.writeWith(Mono.just(dataBuffer));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
