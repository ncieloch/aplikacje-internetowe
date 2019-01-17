package com.nc.webapp.exception.code;

public enum AppExceptionCode {
    E001("Błędny token"),
    E002("Nie znaleziono zasobu"),
    E003("Wartość jest nullem"),
    E004("Użytkownik o podanym identyfikatorze już istnieje");

    private String message;

    AppExceptionCode(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

}
