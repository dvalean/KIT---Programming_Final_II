package edu.kit.informatik.model.deck;

import edu.kit.informatik.model.characters.monster.Monsters;
import edu.kit.informatik.model.characters.monster.Type;

public class MonsterDeck extends Deck<Monsters> {

    public MonsterDeck(int level) {
        for (Monsters monster : Monsters.values()) {
            if (monster.getMonster().getLevel() == level && !monster.getMonster().getType().contains(Type.BOSS)) {
                super.getList().add(monster);
            }
        }
    }

}
