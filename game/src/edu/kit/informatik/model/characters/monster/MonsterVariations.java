package edu.kit.informatik.model.characters.monster;

import java.util.List;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.monster.Bite;
import edu.kit.informatik.model.abilities.monster.Block;
import edu.kit.informatik.model.abilities.monster.Claw;
import edu.kit.informatik.model.abilities.monster.Deflect;
import edu.kit.informatik.model.abilities.monster.Fire;
import edu.kit.informatik.model.abilities.monster.Focus;
import edu.kit.informatik.model.abilities.monster.Ice;
import edu.kit.informatik.model.abilities.monster.Lightning;
import edu.kit.informatik.model.abilities.monster.Scratch;
import edu.kit.informatik.model.abilities.monster.Smash;
import edu.kit.informatik.model.abilities.monster.Water;

public enum MonsterVariations {
    SPIDER_KING(1, List.of(MonsterTypes.BLITZ, MonsterTypes.BOSS), 50,
            List.of(new Bite(1), new Block(1), new Focus(1), new Lightning(1))),
    FROG(1, List.of(MonsterTypes.WATER), 16, List.of(new Focus(1), new Water(1))),
    GHOST(1, List.of(MonsterTypes.ICE), 15, List.of(new Focus(1), new Ice(1))),
    GORGON(1, List.of(MonsterTypes.FIRE), 13, List.of(new Focus(1), new Fire(1))),
    SKELETON(1, List.of(MonsterTypes.BLITZ), 14, List.of(new Focus(1), new Lightning(1))),
    SPIDER(1, List.of(), 15, List.of(new Bite(1), new Block(1))),
    GOBLIN(1, List.of(), 12, List.of(new Smash(1), new Deflect(1))),
    RAT(1, List.of(), 14, List.of(new Block(1), new Claw(1))),
    MUSHROOMLIN(1, List.of(), 20, List.of(new Deflect(1), new Scratch(1))),
    MEGA_SAURUS(2, List.of(MonsterTypes.BOSS), 100,
            List.of(new Bite(2), new Block(2), new Focus(2), new Fire(1), new Lightning(1))),
    SNAKE(2, List.of(MonsterTypes.ICE), 31, List.of(new Bite(2), new Focus(2), new Ice(2))),
    DARK_ELF(2, List.of(), 34, List.of(new Focus(2), new Water(1), new Lightning(1))),
    SHADOWN_BLADE(2, List.of(MonsterTypes.BLITZ), 27, List.of(new Scratch(2), new Focus(2), new Lightning(2))),
    HORNET(2, List.of(MonsterTypes.FIRE), 32, List.of(new Scratch(2), new Focus(2), new Fire(1), new Fire(2))),
    TARANTULA(2, List.of(), 33, List.of(new Bite(2), new Block(2), new Scratch(2))),
    BEAR(2, List.of(), 40, List.of(new Claw(2), new Deflect(2), new Block(2))),
    MUSHROOMLON(2, List.of(), 50, List.of(new Deflect(2), new Scratch(2), new Block(2))),
    WILD_BOAR(2, List.of(), 27, List.of(new Scratch(2), new Deflect(2), new Scratch(2)));

    private final Monster monster;

    private MonsterVariations(int level, List<MonsterTypes> type, int hp, List<Ability> abilities) {
        this.monster = new Monster(level, type, hp, abilities, this.toString());
    }

    public Monster getMonster() {
        return this.monster;
    }

    @Override
    public String toString() {
        String[] arr = super.toString().toLowerCase().split("_");
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            buffer.append(Character.toUpperCase(arr[i].charAt(0))).append(arr[i].substring(1)).append(" ");
        }

        return buffer.toString().trim();
    }
}
