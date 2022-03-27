package edu.kit.informatik.model.characters.runa;

import java.util.ArrayList;
import java.util.List;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.runa.Focus;
import edu.kit.informatik.model.abilities.runa.Parry;
import edu.kit.informatik.model.abilities.runa.Reflect;
import edu.kit.informatik.model.abilities.runa.Slash;
import edu.kit.informatik.model.abilities.runa.Thrust;
import edu.kit.informatik.model.abilities.runa.Water;
import edu.kit.informatik.model.characters.Character;

public class Runa extends Character {
    
    private static final String name = "Runa";
    private static final int MAX_HP = 50;
    private static final int INITIAL_FP = 1;

    private final ClassType type;
    private final List<Ability> abilities;
    
    private int dice;
    private int roll;

    public Runa(ClassType type) {
        super(MAX_HP, INITIAL_FP, name);

        this.type = type;
        this.abilities = new ArrayList<>();
        this.abilities.addAll(classPowers(1));
        this.dice = 4;
    }

    public int getMaxHp() {
        return MAX_HP;
    }

    public int getDice() {
        return this.dice;
    }

    public void upgradeDice() {
        this.dice += 2;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getRoll() {
        return this.roll;
    }

    public void setIntent(int index) {
        super.intent = this.abilities.get(index - 1);
    }

    public List<Ability> classPowers(int level) {
        switch (this.type) {
            case WARRIOR:
                return List.of(new Thrust(level, this), new Parry(level, this));

            case MAGE:
                return List.of(new Focus(level, this), new Water(level, this));

            case PALADIN:
                return List.of(new Slash(level, this), new Reflect(level, this));

            default:
                // TODO: Exception
                throw new IllegalArgumentException();
        }
    }

    public void upgradeAbility() {
        List<Ability> temp = new ArrayList<>();
        temp.addAll(classPowers(2));

        this.abilities.addAll(temp);
    }

    public void addAbility(List<Ability> temp) {
        this.abilities.addAll(temp);
    }

    public void removeAbility(List<Ability> temp) {
        this.abilities.removeAll(temp);
    }

    public void heal(int heal) {
        this.hp += heal;

        if (this.hp > MAX_HP) {
            this.hp = MAX_HP;
        }
    }

    @Override
    public List<Ability> abilities() {
        return this.abilities;
    }

    @Override
    public boolean isType(Object o) {
        ClassType type = (ClassType) o;
        return this.type.toString().equals(type.toString());
    }    
}
