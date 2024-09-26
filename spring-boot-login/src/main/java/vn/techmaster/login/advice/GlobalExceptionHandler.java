package vn.techmaster.login.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vn.techmaster.login.exception.HttpBadRequestException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpBadRequestException.class)
    public ResponseEntity<Object> handle(
        HttpBadRequestException e
    ) {
        return ResponseEntity
            .badRequest()
            .body(e.getErrors());
    }
}
