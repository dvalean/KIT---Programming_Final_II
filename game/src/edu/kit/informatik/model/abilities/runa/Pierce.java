package edu.kit.informatik.model.abilities.runa;

import java.util.Optional;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityAction;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;
import edu.kit.informatik.model.characters.runa.Runa;

public class Pierce extends Ability {

    private static final String name = "Pierce";
    private final Runa runa;

    public Pierce(int level, Runa runa) {
        super(level);
        this.runa = runa;
        
        super.name = name;
        super.action = AbilityAction.ATTACK;
        super.type = AbilityType.PHYSICAL;
    }

    @Override
    public void execute(Optional<Character> target) {
        int damage = 7 * super.level + this.runa.getRoll();
        damage += this.runa.getRoll() < 6 ? 0 : 5 * super.level;

        this.runa.action(damage);        
    }
    
}
