package edu.kit.informatik.model.abilities;

import java.util.Optional;

import edu.kit.informatik.model.characters.Character;

public abstract class Ability {
    
    private static final String REGEX = "%s(%d)";

    protected final int level;

    protected String name;
    protected AbilityAction action;
    protected AbilityType type;

    protected boolean breakFocus;

    public Ability(int level) {
        this.level = level;

        this.breakFocus = false;
    }

    public AbilityAction getAction() {
        return this.action;
    }

    public AbilityType getType() {
        return this.type;
    }

    public boolean breakFocus() {
        return this.breakFocus;
    }

    public int getLevel() {
        return level;
    }

    public abstract void execute(Optional<Character> character);

    @Override
    public String toString() {
        return String.format(REGEX, this.name, this.level);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        Ability ability = (Ability) o;
        if (this.name.equals(ability.name) && this.level == ability.level) {
            return true;
        }

        return false;
    }
}
