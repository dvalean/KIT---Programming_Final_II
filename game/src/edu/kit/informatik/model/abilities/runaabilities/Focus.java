package edu.kit.informatik.model.abilities.runaabilities;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.characters.Character;

public class Focus extends Ability {

    public Focus(int level) {
        super(level);
    }

    @Override
    public void effect(Character user) {
        user.focus(super.getLevel());        
    }
    
}
