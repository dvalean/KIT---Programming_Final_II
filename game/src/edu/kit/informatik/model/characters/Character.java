package edu.kit.informatik.model.characters;

import java.util.List;

import edu.kit.informatik.model.abilities.Ability;

public abstract class Character {
    private final String name;
    
    protected int hp;
    protected int fp;

    protected Ability intent;
    private int actionValue;
    private int predictedFP;

    public Character(int hp, int fp, String name) {
        this.hp = hp;
        this.fp = fp;
        this.name = name;

        this.actionValue = 0;
        this.predictedFP = 0;
    }

    public int getHp() {
        return this.hp;
    }

    public int getFp() {
        return this.fp;
    }

    public String getName() {
        return this.name;
    }

    public void loseFp(int cost) {
        this.fp -= cost;
    }

    public void addFp(int focus) {
        this.fp += focus;
    }

    public void loseHp(int damage) {
        this.hp -= damage;
    }

    public void action(int actionValue) {
        this.actionValue = actionValue;

        if (actionValue < 0) {
            this.actionValue = 0;
        }
    }

    public int getActionValue() {
        return this.actionValue;
    }

    public void focus(int buff) {
        this.predictedFP = buff;
    }

    public int getPredictedFP() {
        return this.predictedFP;
    }

    public Ability getIntent() {
        return this.intent;
    }

    public abstract List<Ability> abilities();

    public abstract boolean isType(Object o);
}
