package edu.kit.informatik.model.characters.monster;

import java.util.List;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.monsterabilities.Bite;
import edu.kit.informatik.model.abilities.monsterabilities.Block;
import edu.kit.informatik.model.abilities.monsterabilities.Claw;
import edu.kit.informatik.model.abilities.monsterabilities.Deflect;
import edu.kit.informatik.model.abilities.monsterabilities.Fire;
import edu.kit.informatik.model.abilities.monsterabilities.Focus;
import edu.kit.informatik.model.abilities.monsterabilities.Ice;
import edu.kit.informatik.model.abilities.monsterabilities.Lightning;
import edu.kit.informatik.model.abilities.monsterabilities.Scratch;
import edu.kit.informatik.model.abilities.monsterabilities.Smash;
import edu.kit.informatik.model.abilities.monsterabilities.Water;

public enum Monsters {
    SPIDER_KING(1, List.of(Type.BLITZ, Type.BOSS), 50,
            List.of(new Bite(1), new Block(1), new Focus(1), new Lightning(1))),
    FROG(1, List.of(Type.WATER), 16, List.of(new Focus(1), new Water(1))),
    GHOST(1, List.of(Type.ICE), 15, List.of(new Focus(1), new Ice(1))),
    GORGON(1, List.of(Type.FIRE), 13, List.of(new Focus(1), new Fire(1))),
    SKELETON(1, List.of(Type.BLITZ), 14, List.of(new Focus(1), new Lightning(1))),
    SPIDER(1, 15, List.of(new Bite(1), new Block(1))),
    GOBLIN(1, 12, List.of(new Smash(1), new Deflect(1))),
    RAT(1, 14, List.of(new Block(1), new Claw(1))),
    MUSHROOMLIN(1, 20, List.of(new Deflect(1), new Scratch(1))),
    MEGA_SAURUS(2, List.of(Type.BOSS), 100,
            List.of(new Bite(2), new Block(2), new Focus(2), new Fire(1), new Lightning(1))),
    SNAKE(2, List.of(Type.ICE), 31, List.of(new Bite(2), new Focus(2), new Ice(2))),
    DARK_ELF(2, 34, List.of(new Focus(2), new Water(1), new Lightning(1))),
    SHADOWN_BLADE(2, List.of(Type.BLITZ), 27, List.of(new Scratch(2), new Focus(2), new Lightning(2))),
    HORNET(2, List.of(Type.FIRE), 32, List.of(new Scratch(2), new Focus(2), new Fire(1), new Fire(2))),
    TARANTULA(2, 33, List.of(new Bite(2), new Block(2), new Scratch(2))),
    BEAR(2, 40, List.of(new Claw(2), new Deflect(2), new Block(2))),
    MUSHROOMLON(2, 50, List.of(new Deflect(2), new Scratch(2), new Block(2))),
    WILD_BOAR(2, 27, List.of(new Scratch(2), new Deflect(2), new Scratch(2)));

    private final Monster monster;

    private Monsters(int level, List<Type> type, int hp, List<Ability> abilities) {
        this.monster = new Monster(level, type, hp, abilities);
    }

    private Monsters(int level, int hp, List<Ability> abilities) {
        this.monster = new Monster(level, List.of(Type.NONE), hp, abilities);
    }

    public Monster getMonster() {
        return this.monster;
    }

    @Override
    public String toString() {
        String temp0 = super.toString().toLowerCase();
        return temp0.substring(0, 1).toUpperCase() + temp0.substring(1);
    }
}
