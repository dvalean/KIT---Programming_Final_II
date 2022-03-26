package edu.kit.informatik.model.abilities.runa;

import java.util.Optional;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityAction;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;
import edu.kit.informatik.model.characters.monster.MonsterTypes;
import edu.kit.informatik.model.characters.runa.Runa;

public class Fire extends Ability{

    private static final String name = "Fire";
    private final Runa runa;

    public Fire(int level, Runa runa) {
        super(level);
        this.runa = runa;
        
        super.name = name;
        super.action = AbilityAction.ATTACK;
        super.type = AbilityType.MAGICAL;
    }

    @Override
    public void execute(Optional<Character> target) {
        int damage = (2 * super.level + 5) * this.runa.getFp();
        damage += target.get().isType(MonsterTypes.ICE) ? 2 * super.level : 0;

        this.runa.action(damage);
        if (this.runa.getFp() > 1) {
            this.runa.loseFp(1);
        }       
    }
    
}
