package org.example;

public enum ExceptionType {
    FILE_NOT_FOUND("File not found"),
    INVALID_FILE_TYPE("Invalid type of file"),
    INTERNAL_CSV_EXCEPTION("Internal csv exception");

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
