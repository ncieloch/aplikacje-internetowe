package com.nc.webapp.error;

import com.nc.webapp.exception.AppRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({AppRuntimeException.class})
    public ResponseEntity<Object> handleAppException(final AppRuntimeException e, final WebRequest request) {
        final String bodyOfResponse = e.getCode().message();
        log.error(e.getMessage(), e);
        return handleExceptionInternal(e, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
