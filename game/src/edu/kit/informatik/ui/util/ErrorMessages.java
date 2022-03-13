package edu.kit.informatik.ui.util;

public enum ErrorMessages {
    INVALID_INPUT("an invalid input was entered.");

    private static final String PREFIX = "Error, ";
    private final String message;

    private ErrorMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + this.message;
    }
}
