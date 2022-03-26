package edu.kit.informatik.model.abilities.runa;

import java.util.Optional;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityAction;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;
import edu.kit.informatik.model.characters.runa.Runa;

public class Reflect extends Ability {

    private static final String name = "Reflect";
    private final Runa runa;

    public Reflect(int level, Runa runa) {
        super(level);
        this.runa = runa;

        super.name = name;
        super.action = AbilityAction.REFLECT;
        super.type = AbilityType.MAGICAL;
    }

    @Override
    public void execute(Optional<Character> target) {
        int reflect = 10 * super.level;       
        
        this.runa.action(reflect);
    }
    
}
