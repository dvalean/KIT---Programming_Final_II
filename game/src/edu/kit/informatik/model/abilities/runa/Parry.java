package edu.kit.informatik.model.abilities.runa;

import java.util.Optional;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityAction;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;
import edu.kit.informatik.model.characters.runa.Runa;

public class Parry extends Ability {

    private static final String name = "Parry";
    private final Runa runa;

    public Parry(int level, Runa runa) {
        super(level);
        this.runa = runa;

        super.name = name;
        super.action = AbilityAction.DEFEND;
        super.type = AbilityType.PHYSICAL;
    }

    @Override
    public void execute(Optional<Character> target) {
        int block = 7 * super.level;
        
        this.runa.action(block);
    }
    
}
