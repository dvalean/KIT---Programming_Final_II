package edu.kit.informatik.model.abilities.monster;

import java.util.Optional;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityAction;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;

public class Scratch extends Ability {

    private static final String name = "Scratch";

    public Scratch(int level) {
        super(level);

        super.name = name;
        super.action = AbilityAction.ATTACK;
        super.type = AbilityType.PHYSICAL;
        super.breakFocus = true;
    }

    @Override
    public void execute(Optional<Character> monster) {
        int damage = 5 * super.level;

        monster.get().action(damage);
    }
    
}
