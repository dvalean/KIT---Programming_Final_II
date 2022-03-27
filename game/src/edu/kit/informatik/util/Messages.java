package edu.kit.informatik.util;

public enum Messages {
    WELCOME("Welcome to Runa's Strive"),
    SELECT_CLASS("Select Runa's character class"),
    CLASS("%d) %s"),
    SHUFFLE("To shuffle ability cards and monsters, enter two seeds"),
    ENTER_ROOM("Runa enters Stage %d of Level %d"),
    BREAK_LINES("-".repeat(40)),
    RUNA("Runa (%d/%d HP, %d/%d FP)"),
    VS("vs."),
    MONSTER("%s (%d HP, %d FP): attempts %s next"),
    SELECT_ABILITY("Select card to play"),
    SELECT_TARGET("Select Runa's target."),
    ENUMERATION("%d) %s"),
    CHARACTER_USES("%s uses %s"),
    CHARACTER_TAKE_DMG("%s takes %d %s damage"),
    CHARACTER_DIES("%s dies"),
    GAIN_FOCUS("%s gains %d focus"),
    CHOOSE_REWARD("Choose Runa's reward"),
    ABILITY_CARD("1) new ability cards"),
    NEXT_DICE("2) next player dice"),
    DICE_UPGRADE("Runa upgrades her die to a d%d"),
    PICK_CARDS("Pick %d card(s) as loot"),
    HEALING("Runa (%d/%d HP) can discard ability cards for healing (or none)"),
    GET_CARD("Runa gets %s"),
    HEAL("Runa gains %d health"),
    WIN("Runa won!"),
    DEFEAT("Runa dies"),

    ENTER_NUMBER("Enter number [1--%d]:"),
    ENTER_SEEDS("Enter seeds [1--%d] separated by comma:"),
    ENTER_NUMBERS("Enter numbers [1--%d] separated by comma:"),
    ENTER_DICE_ROLL("Enter dice roll [1--%d]:");

    private final String message;

    private Messages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
