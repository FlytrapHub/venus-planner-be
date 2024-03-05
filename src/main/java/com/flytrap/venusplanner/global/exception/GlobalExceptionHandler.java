package com.flytrap.venusplanner.global.exception;

import com.flytrap.venusplanner.global.exception.custom.ApiRequestFailureException;
import com.flytrap.venusplanner.global.exception.custom.AuthenticationFailedException;
import com.flytrap.venusplanner.global.exception.custom.DomainNotFoundException;
import com.flytrap.venusplanner.global.exception.custom.ForbiddenException;
import com.flytrap.venusplanner.global.exception.custom.NoSuchEnumTypeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    protected ExceptionResponse handleException(Exception exception) {
        log(exception);

        return ExceptionResponse.from(exception);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationFailedException.class)
    protected ExceptionResponse handleAuthenticationFailedException(AuthenticationFailedException exception) {
        log(exception);

        return ExceptionResponse.from(exception);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(ForbiddenException.class)
    protected ExceptionResponse handleForbiddenException(ForbiddenException exception) {
        log(exception);

        return ExceptionResponse.from(exception);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DomainNotFoundException.class)
    protected ExceptionResponse handleDomainNotFoundException(DomainNotFoundException exception) {
        log(exception);

        return ExceptionResponse.from(exception);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchEnumTypeException.class)
    protected ExceptionResponse handleNoSuchEnumTypeException(NoSuchEnumTypeException exception) {
        log(exception);

        return ExceptionResponse.from(exception);
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(ApiRequestFailureException.class)
    protected ExceptionResponse handleApiRequestFailureException(ApiRequestFailureException exception) {
        log(exception);

        return ExceptionResponse.from(exception);
    }

    private void log(Exception exception) {
        log.error("Exception occurred!: ", exception);
    }
}
