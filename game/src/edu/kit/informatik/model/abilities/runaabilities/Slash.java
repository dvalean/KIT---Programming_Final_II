package edu.kit.informatik.model.abilities.runaabilities;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;

public class Slash extends Ability {
    public Slash(int level) {
        super(level);
        super.setCancelsFocus(true);
        super.setRequiresDiceRoll(true);
    }

    @Override
    public void effect(Character user) {
        user.attack(4 * super.getLevel() + user.getRoll(), AbilityType.PHYSICAL);
    }
}
