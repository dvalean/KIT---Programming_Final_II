package edu.kit.informatik.model.abilities.monster;

import java.util.Optional;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityAction;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;

public class Focus extends Ability {

    private static final String name = "Focus";

    public Focus(int level) {
        super(level);

        super.name = name;
        super.action = AbilityAction.BUFF;
        super.type = AbilityType.MAGICAL;
    }

    @Override
    public void execute(Optional<Character> monster) {
        int buff = super.level;

        monster.get().focus(buff);
    }
    
}
