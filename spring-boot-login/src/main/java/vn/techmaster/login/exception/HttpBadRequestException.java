package vn.techmaster.login.exception;

import lombok.Getter;

@Getter
public class HttpBadRequestException extends RuntimeException {

    private final Object errors;

    public HttpBadRequestException(Object errors) {
        super("Bad request");
        this.errors = errors;
    }
}
