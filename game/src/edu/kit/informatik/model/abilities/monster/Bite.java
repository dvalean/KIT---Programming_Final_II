package edu.kit.informatik.model.abilities.monster;

import java.util.Optional;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityAction;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;

public class Bite extends Ability {

    private static final String name = "Bite";

    public Bite(int level) {
        super(level);

        super.name = name;
        super.action = AbilityAction.ATTACK;
        super.type = AbilityType.PHYSICAL;
    }

    @Override
    public void execute(Optional<Character> monster) {
        int damage = 10 * super.level;

        monster.get().action(damage);
    }
    
}
