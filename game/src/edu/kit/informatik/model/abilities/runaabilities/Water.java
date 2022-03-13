package edu.kit.informatik.model.abilities.runaabilities;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;

public class Water extends Ability {
    public Water(int level) {
        super(level);
        super.setCost(1);
        super.setRequiresFocusPts(true);
    }

    @Override
    public void effect(Character user) {
        user.attack((2 * super.getLevel() + 4) * user.getFp(), AbilityType.MAGICAL);
    }
    
}
