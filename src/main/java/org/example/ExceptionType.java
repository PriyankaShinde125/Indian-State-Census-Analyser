package org.example;

public enum ExceptionType {
    FILE_NOT_FOUND("File not found");

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
