package edu.kit.informatik.model.abilities.monster;

import java.util.Optional;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityAction;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;

public class Smash extends Ability {

    private static final String name = "Claw";

    public Smash(int level) {
        super(level);

        super.name = name;
        super.action = AbilityAction.ATTACK;
        super.type = AbilityType.PHYSICAL;
    }

    @Override
    public void execute(Optional<Character> monster) {
        int damage = 8 * super.level;

        monster.get().action(damage);
    }
    
}
