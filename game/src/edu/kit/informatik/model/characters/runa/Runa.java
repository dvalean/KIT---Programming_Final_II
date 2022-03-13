package edu.kit.informatik.model.characters.runa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;

public class Runa extends Character {
    private static final int MAX_HP = 50;
    private static final int INITIAL_DICE = 4;
    private static final int INITIAL_FP = 1;

    private final Role role;
    private final List<Ability> abilities;

    public Runa(Role role) {
        super.setHp(MAX_HP);
        super.setFp(INITIAL_FP);
        this.role = role;
        this.abilities = new ArrayList<>();
        this.abilities.addAll(role.getAbilities());
    }

    @Override
    public void attack(int damage, AbilityType type) {
        super.setDamage(Optional.of(damage)); 
        super.setType(Optional.of(type));      
    }

    @Override
    public void defend(int defence, AbilityType type) {
        super.setDefence(Optional.of(defence));
        super.setType(Optional.of(type));  
    }

    @Override
    public void focus(int level) {
        // TODO Auto-generated method stub        
    }
}
