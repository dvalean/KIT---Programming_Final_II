package edu.kit.informatik.model.characters;

import java.util.Optional;

import edu.kit.informatik.model.abilities.AbilityType;

public abstract class Character {
    private int hp;
    private int fp;

    private int roll;

    private Optional<Integer> damage;
    private Optional<Integer> defence;
    private Optional<AbilityType> type;

    public Character() {

    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return this.hp;
    }

    public void setFp(int fp) {
        this.fp = fp;
    }

    public int getFp() {
        return this.fp;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getRoll() {
        return roll;
    }

    public void setDamage(Optional<Integer> damage) {
        this.damage = damage;
    }

    public Optional<Integer> getDamage() {
        return damage;
    }

    public void setDefence(Optional<Integer> defence) {
        this.defence = defence;
    }

    public Optional<Integer> getDefence() {
        return defence;
    }

    public void setType(Optional<AbilityType> type) {
        this.type = type;
    }

    public Optional<AbilityType> getType() {
        return this.type;
    }

    public abstract void attack(int damage, AbilityType type);
    public abstract void defend(int defence, AbilityType type);
    public abstract void focus(int level);
}
