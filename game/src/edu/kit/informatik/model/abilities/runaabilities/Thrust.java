package edu.kit.informatik.model.abilities.runaabilities;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.Action;
import edu.kit.informatik.model.abilities.Type;
import edu.kit.informatik.model.characters.Character;

public class Thrust extends Ability {

    private static final String name = "Thrust";

    public Thrust(int level) {
        super(level);
        super.name = name;
        super.action = Action.ATTACK;
        super.type = Type.PHYSICAL;
    }

    @Override
    public void execute(Character attacker, Character defender) {
        attacker.setDmgDealt(4 * super.getLevel() + attacker.getRoll());
    }

}
