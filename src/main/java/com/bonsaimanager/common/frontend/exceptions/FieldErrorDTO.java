package com.bonsaimanager.common.frontend.exceptions;

public class FieldErrorDTO {

    private final String field;

    private final String message;

    public FieldErrorDTO(final String field, final String message) {
        this.field = field;
        this.message = message;
    }

    // API

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

}