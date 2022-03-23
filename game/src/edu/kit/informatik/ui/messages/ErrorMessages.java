package edu.kit.informatik.ui.messages;

public enum ErrorMessages {
    UNKNOWN_TYPE("this '%s' - class isn't in the game."),
    INVALID_TYPE_NUMBER("enter numbers between [1--%d] for a valid class.");

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
