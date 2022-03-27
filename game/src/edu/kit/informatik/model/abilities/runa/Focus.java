package edu.kit.informatik.model.abilities.runa;

import java.util.Optional;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityAction;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;
import edu.kit.informatik.model.characters.runa.Runa;

public class Focus extends Ability {

    private static final String name = "Focus";
    private final Runa runa;

    public Focus(int level, Runa runa) {
        super(level);
        this.runa = runa;

        super.name = name;
        super.action = AbilityAction.BUFF;
        super.type = AbilityType.MAGICAL;
    }

    @Override
    public void execute(Optional<Character> target) {
        int buff = this.runa.getFp() + super.level > this.runa.getDice() ? this.runa.getDice() - this.runa.getFp()
                : super.level;

        this.runa.focus(buff);
    }

}
