package edu.kit.informatik.model.abilities.monsterabilities;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.characters.Character;

public class Fire extends Ability {

    private static final String name = "Fire";

    public Fire(int level) {
        super(level);
        super.name = name;
    }

    @Override
    public void execute(Character attacker, Character defender) {
        // TODO Auto-generated method stub
        
    }
    
}
