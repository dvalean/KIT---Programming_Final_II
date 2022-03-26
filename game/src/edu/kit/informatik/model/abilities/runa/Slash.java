package edu.kit.informatik.model.abilities.runa;

import java.util.Optional;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityAction;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;
import edu.kit.informatik.model.characters.runa.Runa;

public class Slash extends Ability {

    private static final String name = "Slash";
    private final Runa runa;

    public Slash(int level, Runa runa) {
        super(level);
        this.runa = runa;

        super.name = name;
        super.action = AbilityAction.ATTACK;
        super.type = AbilityType.PHYSICAL;
        super.breakFocus = true;
    }

    @Override
    public void execute(Optional<Character> target) {
        int damage = 4 * super.level + this.runa.getRoll();

        this.runa.action(damage);
    }
    
}
