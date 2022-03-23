package edu.kit.informatik.model.abilities.monsterabilities;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.characters.Character;

public class Bite extends Ability{

    private static final String name = "Bite";

    public Bite(int level) {
        super(level);
        super.name = name;
    }

    @Override
    public void execute(Character attacker, Character defender) {
        // TODO Auto-generated method stub
        
    }
    
}