package edu.kit.informatik.model.abilities.runaabilities;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;

public class Parry extends Ability {
    public Parry(int level) {
        super(level);
    }

    @Override
    public void effect(Character user) {
        user.defend(7 * super.getLevel(), AbilityType.PHYSICAL);
    }
}
