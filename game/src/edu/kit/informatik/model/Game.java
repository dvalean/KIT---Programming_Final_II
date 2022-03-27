package edu.kit.informatik.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityAction;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.model.characters.Character;
import edu.kit.informatik.model.characters.monster.Monster;
import edu.kit.informatik.model.characters.monster.MonsterVariations;
import edu.kit.informatik.model.characters.runa.Runa;
import edu.kit.informatik.util.Messages;
import edu.kit.informatik.model.characters.runa.ClassType;
import edu.kit.informatik.model.characters.monster.MonsterTypes;
// Abilities
import edu.kit.informatik.model.abilities.runa.Fire;
import edu.kit.informatik.model.abilities.runa.Focus;
import edu.kit.informatik.model.abilities.runa.Ice;
import edu.kit.informatik.model.abilities.runa.Lightning;
import edu.kit.informatik.model.abilities.runa.Parry;
import edu.kit.informatik.model.abilities.runa.Pierce;
import edu.kit.informatik.model.abilities.runa.Reflect;
import edu.kit.informatik.model.abilities.runa.Slash;
import edu.kit.informatik.model.abilities.runa.Swing;
import edu.kit.informatik.model.abilities.runa.Thrust;
import edu.kit.informatik.model.abilities.runa.Water;

public class Game {

    private int level;
    private int room;

    private Runa runa;

    private List<Monster> currentEnemies;
    private List<Monster> enemies;
    private List<Ability> abilities;

    private Monster target;
    private int reflect = 0;
    private int nrEnemies;

    public Game() {
        this.level = 1;
    }

    public int getLevel() {
        return this.level;
    }

    public void nextLevel() {
        this.level++;
    }

    public int getRoom() {
        return this.room;
    }

    public Runa getRuna() {
        return this.runa;
    }

    public Monster getTarget() {
        return this.target;
    }

    public List<Monster> getCurrentEnemies() {
        return this.currentEnemies;
    }

    public List<Ability> getAbilities() {
        return this.abilities;
    }

    public int getNrEnemies() {
        return nrEnemies;
    }

    public void initGame(int typeID) {
        this.runa = new Runa(ClassType.typeById(typeID));
    }

    private void createAbilities(int level) {
        this.abilities.add(new Slash(level, this.runa));
        this.abilities.add(new Swing(level, this.runa));
        this.abilities.add(new Thrust(level, this.runa));
        this.abilities.add(new Pierce(level, this.runa));
        this.abilities.add(new Parry(level, this.runa));
        this.abilities.add(new Focus(level, this.runa));
        this.abilities.add(new Reflect(level, this.runa));
        this.abilities.add(new Water(level, this.runa));
        this.abilities.add(new Ice(level, this.runa));
        this.abilities.add(new Fire(level, this.runa));
        this.abilities.add(new Lightning(level, this.runa));

        this.abilities.removeAll(this.runa.abilities());
    }

    private void createEnemies(int level) {
        for (MonsterVariations monster : MonsterVariations.values()) {
            if (monster.getMonster().getLevel() == level && !monster.getMonster().isType(MonsterTypes.BOSS)) {
                this.enemies.add(monster.getMonster());
            }
        }
    }

    public void initLevel(int abilitySeed, int monsterSeed) {
        this.enemies = new ArrayList<>();
        this.abilities = new ArrayList<>();

        createAbilities(level);
        createEnemies(level);

        this.room = 1;
        Random random;

        random = new Random(abilitySeed);
        Collections.shuffle(this.abilities, random);

        random = new Random(monsterSeed);
        Collections.shuffle(this.enemies, random);
    }

    public void initRoom() {
        this.currentEnemies = new ArrayList<>();

        if (this.room == 4) {
            if (this.level == 1) {
                this.currentEnemies.add(MonsterVariations.SPIDER_KING.getMonster());
            } else {
                this.currentEnemies.add(MonsterVariations.MEGA_SAURUS.getMonster());
            }
        } else if (this.room == 1) {
            this.currentEnemies.add(enemies.get(0));
            this.enemies.remove(0);
        } else {
            this.currentEnemies.add(enemies.get(0));
            this.enemies.remove(0);
            this.currentEnemies.add(enemies.get(0));
            this.enemies.remove(0);
        }

        this.target = this.currentEnemies.get(0);
        this.nrEnemies = this.currentEnemies.size();

        this.room++;
    }

    public void selectTarget(int index) {
        this.target = this.currentEnemies.get(index);
    }

    public int runaEvaluator() {
        this.runa.action(0);
        int damage = 0;
        this.runa.getIntent().execute(Optional.of((Character) target));

        if (this.runa.getIntent().getAction() == AbilityAction.ATTACK) {
            if (this.runa.getIntent().breakFocus()) {
                this.target.focus(0);
            }

            damage = this.runa.getActionValue();
            if (this.target.getMove() != null
                    && this.runa.getIntent().getType().equals(this.target.getMove().getType())
                    && this.target.getMove().getAction() == AbilityAction.DEFEND) {
                damage -= this.target.getActionValue();
            }

            if (damage > 0) {
                this.target.loseHp(damage);
            }

            this.runa.action(0);
        }

        return damage;
    }

    public void deleteTarget(Monster monster) {
        this.currentEnemies.remove(monster);
    }

    public int monsterEvaluator(Monster monster) {
        int damage = 0;
        if (monster.getIntent().getAction() == AbilityAction.ATTACK
                && monster.getIntent().getType() == AbilityType.MAGICAL && monster.getFp() < monster.getIntent().getLevel()) {
            monster.nextIntent();
            return monsterEvaluator(monster);
        }

        monster.getIntent().execute(Optional.of((Character) monster));

        if (monster.getIntent().getAction() == AbilityAction.ATTACK) {
            if (monster.getIntent().breakFocus()) {
                this.runa.focus(0);
            }

            damage = monster.getActionValue();

            if (monster.getIntent().getType().equals(this.runa.getIntent().getType())) {
                if (this.runa.getIntent().getAction() == AbilityAction.REFLECT) {
                    reflect(monster, damage);
                }
                damage -= this.runa.getActionValue();
            }

            if (damage > 0) {
                this.runa.loseHp(damage);
            }

            monster.action(0);
        }

        return damage;
    }

    public void reflect(Monster monster, int damage) {
        int reflect;
        if (damage > this.runa.getActionValue()) {
            reflect = this.runa.getActionValue();
        } else {
            reflect = damage;
        }

        monster.loseHp(reflect);
        this.reflect = reflect;
    }

    public int getReflect() {
        return reflect;
    }

    public void resetReflect() {
        this.reflect = 0;
    }

    public void focus(Character character) {
        if (character.getPredictedFP() != 0) {
            character.addFp(character.getPredictedFP());
            System.out.println(
                    String.format(Messages.GAIN_FOCUS.toString(), character.getName(), character.getPredictedFP()));
            character.focus(0);
        }
    }

    public void addCards(List<Ability> newAbilities, List<Ability> deck) {
        this.runa.addAbility(newAbilities);
        this.abilities.removeAll(deck);
    }
}
