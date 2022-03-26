package edu.kit.informatik.model.abilities;

public enum AbilityType {
    PHYSICAL("phy."),
    MAGICAL("mag.");

    private final String name;

    private AbilityType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
