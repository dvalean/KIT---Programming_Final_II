package edu.kit.informatik.ui.messages;

public enum Messages {
    WELCOME("Welcome to Runa's Strive"),
    SELECT_CLASS("Select Runa's character class"),
    CLASS("%d) %s"),
    ENTER_NUMBER("Enter number [1--%d]:"),
    SHUFFLE("To shuffle ability cards and monsters, enter two seeds\nEnter seeds [1--2147483647] separated by coma:"),
    ENTER_ROOM("Runa enters Stage %d of Level %d"),
    BREAK_LINES("-".repeat(40)),
    RUNA("Runa (%d/%d HP, %d/%d FP)"),
    VS("vs."),
    MONSTER("%s (%d HP, %d FP): attempts %s next"),
    SELECT_CARD("Select card to play"),
    ABILITY("%d) %s(%d)"),
    CHARACTER_USES("%s uses %s"),
    DICE_ROLL("Enter dice roll [1--%d]:");

    private final String message;

    private Messages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
