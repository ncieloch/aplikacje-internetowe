package com.nc.webapp.exception;

import com.nc.webapp.exception.code.AppExceptionCode;
import lombok.Getter;

public class AppRuntimeException extends RuntimeException {

    @Getter
    private AppExceptionCode code;

    public AppRuntimeException(AppExceptionCode code) {
        super(String.format("Code: %s, Message: %s", code.name(), code.message()));
        this.code = code;
    }

    public AppRuntimeException(AppExceptionCode code, String message) {
        super(String.format("Code: %s, Message: %s\n%s", code.name(), code.message(), message));
        this.code = code;
    }

    public AppRuntimeException(AppExceptionCode code, Throwable cause) {
        super(String.format("Code: %s, Message: %s\nCause: %s", code.name(), code.message(), cause), cause);
        this.code = code;
    }

    public AppRuntimeException(AppExceptionCode code, String message, Throwable cause) {
        super(String.format("Code: %s, Message: %s\n%s\nCause: %s", code.name(), code.message(), message, cause), cause);
        this.code = code;
    }

}
