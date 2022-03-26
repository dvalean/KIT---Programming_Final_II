package edu.kit.informatik.model.abilities.runa;

import java.util.Optional;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityAction;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;
import edu.kit.informatik.model.characters.runa.Runa;

public class Swing extends Ability {

    private static final String name = "Swing";
    private final Runa runa;

    public Swing(int level, Runa runa) {
        super(level);
        this.runa = runa;

        super.name = name;
        super.action = AbilityAction.ATTACK;
        super.type = AbilityType.PHYSICAL;
    }

    @Override
    public void execute(Optional<Character> target) {
        int damage = 5 * super.level + this.runa.getRoll();

        this.runa.action(damage);
    }
    
}
