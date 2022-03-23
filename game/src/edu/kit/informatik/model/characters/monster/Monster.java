package edu.kit.informatik.model.characters.monster;

import java.util.List;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.characters.Character;

public class Monster extends Character {
    private final int level;
    private final List<Type> type;
    private final List<Ability> abilities;
    private int moveCounter;

    public Monster(int level, List<Type> type, int hp, List<Ability> abilities) {
        this.level = level;
        this.type = type;
        this.abilities = abilities;
        super.setHp(hp);
        super.setFp(0);
        this.moveCounter = 0;
    }

    public int getLevel() {
        return this.level;
    }

    public List<Type> getType() {
        return this.type;
    }

    public List<Ability> getAbilities() {
        return this.abilities;
    }

    public Ability getNextMove() {
        Ability result = this.abilities.get(this.moveCounter);

        return result;
    }

    public void nextMove() {
        if (++this.moveCounter > this.abilities.size() - 1) {
            this.moveCounter = 0;
        }
    }
}
