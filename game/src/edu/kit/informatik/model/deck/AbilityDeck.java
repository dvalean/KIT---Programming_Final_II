package edu.kit.informatik.model.deck;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.runaabilities.*;

public class AbilityDeck extends Deck<Ability> {
    
    public AbilityDeck(int level) {
        super.getList().add(new Slash(level));
        super.getList().add(new Swing(level));
        super.getList().add(new Thrust(level));
        super.getList().add(new Pierce(level));
        super.getList().add(new Parry(level));
        super.getList().add(new Focus(level));
        super.getList().add(new Reflect(level));
        super.getList().add(new Water(level));
        super.getList().add(new Ice(level));
        super.getList().add(new Fire(level));
        super.getList().add(new Lightning(level));
    }

}
