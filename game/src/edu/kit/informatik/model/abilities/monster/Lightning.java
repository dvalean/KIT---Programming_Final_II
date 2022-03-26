package edu.kit.informatik.model.abilities.monster;

import java.util.Optional;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityAction;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;

public class Lightning extends Ability {

    private static final String name = "Lightning";

    public Lightning(int level) {
        super(level);

        super.name = name;
        super.action = AbilityAction.ATTACK;
        super.type = AbilityType.MAGICAL;
    }

    @Override
    public void execute(Optional<Character> monster) {
        int damage = 14 * super.level + 2;
        
        monster.get().action(damage);
        monster.get().loseFp(super.level);
    }
    
}
