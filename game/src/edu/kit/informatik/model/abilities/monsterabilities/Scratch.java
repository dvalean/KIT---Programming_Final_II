package edu.kit.informatik.model.abilities.monsterabilities;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.characters.Character;

public class Scratch extends Ability {

    private static final String name = "Scratch";

    public Scratch(int level) {
        super(level);
        super.name = name;
    }

    @Override
    public void execute(Character attacker, Character defender) {
        // TODO Auto-generated method stub
        
    }
    
}
