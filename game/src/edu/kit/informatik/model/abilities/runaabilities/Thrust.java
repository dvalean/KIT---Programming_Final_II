package edu.kit.informatik.model.abilities.runaabilities;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;

public class Thrust extends Ability {
    public Thrust(int level) {
        super(level);
        super.setRequiresDiceRoll(true);
    }

    @Override
    public void effect(Character user) {
        if (user.getRoll() < 6) {
            user.attack(6 * super.getLevel() + user.getRoll(), AbilityType.PHYSICAL);
        } else {
            user.attack(6 * super.getLevel() + user.getRoll() + 5 * super.getLevel(), AbilityType.PHYSICAL);
        }
    }
}
