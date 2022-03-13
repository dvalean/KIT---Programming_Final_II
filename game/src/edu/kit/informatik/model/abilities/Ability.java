package edu.kit.informatik.model.abilities;

import edu.kit.informatik.model.characters.Character;

public abstract class Ability {
    private final int level;
    private int cost;
    private boolean cancelsFocus;
    private boolean requiresDiceRoll;
    private boolean requiresFocusPts;

    public Ability(int level) {
        this.level = level;
        this.cost = 0;
        this.cancelsFocus = false;
        this.requiresDiceRoll = false;
        this.requiresFocusPts = false;
    }

    public int getLevel() {
        return this.level;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean cancelsFocus() {
        return this.cancelsFocus;
    }

    public void setCancelsFocus(boolean cancelsFocus) {
        this.cancelsFocus = cancelsFocus;
    }

    public boolean requiresDiceRoll() {
        return this.requiresDiceRoll;
    }

    public void setRequiresDiceRoll(boolean requiresDiceRoll) {
        this.requiresDiceRoll = requiresDiceRoll;
    }

    public boolean requiresFocusPts() {
        return this.requiresFocusPts;
    }

    public void setRequiresFocusPts(boolean requiresFocusPts) {
        this.requiresFocusPts = requiresFocusPts;
    }

    public abstract void effect(Character user);
}
