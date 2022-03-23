package edu.kit.informatik.model;

import java.util.ArrayList;
import java.util.List;

import edu.kit.informatik.model.characters.monster.Monsters;
import edu.kit.informatik.model.characters.runa.Runa;
import edu.kit.informatik.model.characters.runa.Type;
import edu.kit.informatik.model.deck.AbilityDeck;
import edu.kit.informatik.model.deck.MonsterDeck;

public class Game {

    private int level;
    private int room;

    private Runa runa;
    private List<Monsters> currEnemies;

    private AbilityDeck abilities;
    private MonsterDeck monsters;

    public Game() {

    }

    public int getLevel() {
        return this.level;
    }

    public int getRoom() {
        return this.room;
    }

    public Runa getRuna() {
        return this.runa;
    }
    
    public List<Monsters> getCurrEnemies() {
        return this.currEnemies;
    }

    public void initGame(int typeNr) {
        this.level = 1;
        this.room = 1;
        this.runa = new Runa(Type.typeByNr(typeNr));

        this.abilities = new AbilityDeck(this.level);
        this.abilities.getList().removeAll(this.runa.getAbilities());
    }

    public void initLevel(int abilitySeed, int monsterSeed) {
        this.abilities.shuffle(abilitySeed);

        this.monsters = new MonsterDeck(level);
        this.monsters.shuffle(monsterSeed);
    }

    public void initRoom() {
        this.currEnemies = new ArrayList<>();

        if (this.room == 4) {
            if (this.level == 1) {
                this.currEnemies = List.of(Monsters.SPIDER_KING);
            } else {
                this.currEnemies = List.of(Monsters.MEGA_SAURUS);
            }
        } else if (this.room == 1) {
            this.currEnemies.add(monsters.getList().get(0));
            this.monsters.getList().remove(0);
        } else {
            this.currEnemies.add(monsters.getList().get(0));
            this.monsters.getList().remove(0);
            this.currEnemies.add(monsters.getList().get(0));
            this.monsters.getList().remove(0);
        }

        this.room++;
    }

    public void fight(List<Integer> arguments) {
        this.runa.getAbilities().get(arguments.get(0) - 1).execute(this.runa, this.currEnemies.get(0).getMonster());

        for (Monsters monster : this.currEnemies) {
            monster.getMonster().getNextMove().execute(monster.getMonster(), this.runa);
            monster.getMonster().nextMove();
        }

        this.currEnemies.get(0).getMonster().loseHp(this.runa.getDmgDealt());

        for (Monsters monster : this.currEnemies) {
            this.runa.loseHp(monster.getMonster().getDmgDealt());
        }
    }

}
