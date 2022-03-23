package edu.kit.informatik.model.characters.runa;

import java.util.List;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.characters.Character;

public class Runa extends Character {

    private static final int MAX_HP = 50;
    private static final int INITIAL_FP = 1;

    private final Type type;
    private final List<Ability> abilities;
    private int dice;

    public Runa(Type type) {
        super.setHp(MAX_HP);
        super.setFp(INITIAL_FP);
        this.type = type;
        this.abilities = type.typePowers(1);
        this.dice = 4;
    }

    public int getMaxHp() {
        return MAX_HP;
    }

    public Type getType() {
        return this.type;
    }

    public List<Ability> getAbilities() {
        return this.abilities;
    }

    public int getDice() {
        return this.dice;
    }
    
}
