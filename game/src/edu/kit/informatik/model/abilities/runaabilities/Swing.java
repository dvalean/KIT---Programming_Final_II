package edu.kit.informatik.model.abilities.runaabilities;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;

public class Swing extends Ability {
    public Swing(int level) {
        super(level);
        super.setCancelsFocus(true);
        super.setRequiresDiceRoll(true);
    }

    @Override
    public void effect(edu.kit.informatik.model.characters.Character user) {
        user.attack(5 * super.getLevel() + user.getRoll(), AbilityType.PHYSICAL);
    }
}
