package edu.kit.informatik.model.characters.monster;

import java.util.List;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.characters.Character;

public class Monster extends Character {

    private static final int INITIAL_FP = 0;

    private final int level;
    private final List<MonsterTypes> type;
    private final List<Ability> abilities;

    public Monster(int level, List<MonsterTypes> type, int hp, List<Ability> abilities, String name) {
        super(hp, INITIAL_FP, name);

        this.level = level;
        this.type = type;
        this.abilities = abilities;

        super.intent = this.abilities.get(0);
    }

    public int getLevel() {
        return this.level;
    }

    public List<Ability> getAbilities() {
        return this.abilities;
    }

    public void nextIntent() {
        if (this.abilities.indexOf(super.intent) < this.abilities.size() - 1) {        
            super.intent = this.abilities.get(this.abilities.indexOf(super.intent) + 1);            
        } else {
            super.intent = this.abilities.get(0);
        }
    }

    @Override
    public List<Ability> abilities() {
        return this.abilities;
    }

    @Override
    public boolean isType(Object o) {
        return this.type.contains(o) ? true : false;
    }    
}
