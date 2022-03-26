package edu.kit.informatik.model.abilities.monster;

import java.util.Optional;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityAction;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;

public class Block extends Ability {

    private static final String name = "Block";

    public Block(int level) {
        super(level);

        super.name = name;
        super.action = AbilityAction.DEFEND;
        super.type = AbilityType.PHYSICAL;
    }

    @Override
    public void execute(Optional<Character> monster) {
        int block = 7 * super.level;

        monster.get().action(block);        
    }
    
}
