package com.nc.webapp.util;

import com.nc.webapp.exception.AppRuntimeException;
import com.nc.webapp.exception.code.AppExceptionCode;

public class RestPreconditions {

    private RestPreconditions() {
        throw new AssertionError();
    }

    public static void checkFound(final boolean expression) {
        if (!expression) {
            throw new AppRuntimeException(AppExceptionCode.E002);
        }
    }

    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new AppRuntimeException(AppExceptionCode.E002);
        }

        return resource;
    }

    public static <T> T checkNotNull(final T resource) {
        if (resource == null) {
            throw new AppRuntimeException(AppExceptionCode.E003);
        }

        return resource;
    }

}
