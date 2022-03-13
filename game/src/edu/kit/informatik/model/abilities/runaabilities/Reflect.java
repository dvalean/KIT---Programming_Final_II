package edu.kit.informatik.model.abilities.runaabilities;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;

public class Reflect extends Ability {

    public Reflect(int level) {
        super(level);
    }

    @Override
    public void effect(Character user) {
        user.defend(10 * super.getLevel(), AbilityType.MAGICAL);
        user.attack(user.getDefence().get(), AbilityType.PHYSICAL);
    }
    
}
