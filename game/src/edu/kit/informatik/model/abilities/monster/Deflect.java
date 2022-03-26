package edu.kit.informatik.model.abilities.monster;

import java.util.Optional;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityAction;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;

public class Deflect extends Ability {

    private static final String name = "Deflect";

    public Deflect(int level) {
        super(level);

        super.name = name;
        super.action = AbilityAction.DEFEND;
        super.type = AbilityType.MAGICAL;
    }

    @Override
    public void execute(Optional<Character> monster) {
        int block = 11 * super.level + 2;
        
        monster.get().action(block);
    }
    
}
