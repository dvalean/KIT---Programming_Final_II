package edu.kit.informatik.ui;

import java.util.ArrayList;
import java.util.List;

import edu.kit.informatik.model.Game;
import edu.kit.informatik.model.characters.monster.Monster;
import edu.kit.informatik.util.Messages;

public class MonsterEvaluator implements GameStates {

    private static final int ARGUMENTS_NUMBER = 0;
    private static final int LIMIT = 0;

    private final Session session;
    private final Game game;

    public MonsterEvaluator(Session session, Game game) {
        this.session = session;
        this.game = game;
    }

    @Override
    public int maxArgumentsNumber() {
        return ARGUMENTS_NUMBER;
    }

    @Override
    public int minArgumentsNumber() {
        return ARGUMENTS_NUMBER;
    }

    @Override
    public int limit() {
        return LIMIT;
    }

    @Override
    public void message() {
        return;
    }

    @Override
    public void inputMessage() {
        return;
    }

    @Override
    public void execute(List<Integer> arguments) {
        for (Monster monster : this.game.getCurrentEnemies()) {
            this.game.focus(monster);
        }

        for (Monster monster : this.game.getCurrentEnemies()) {
            int action = this.game.monsterEvaluator(monster);
            System.out
                    .println(String.format(Messages.CHARACTER_USES.toString(), monster.getName(), monster.getIntent()));
            if (action > 0) {
                System.out.println(String.format(Messages.CHARACTER_TAKE_DMG.toString(),
                        this.game.getRuna().getName(), action, monster.getIntent().getType().toString()));
            }

            if (this.game.getRuna().getHp() < 1) {
                System.out.println(Messages.DEFEAT.toString());
                this.session.stop();
                return;
            }

            if (this.game.getReflect() != 0) {
                System.out.println(String.format(Messages.CHARACTER_TAKE_DMG.toString(), monster.getName(),
                        this.game.getReflect(), this.game.getRuna().getIntent().getType().toString()));
                this.game.resetReflect();
            }

            monster.nextIntent();

            if (monster.getHp() < 1) {
                System.out.println(String.format(Messages.CHARACTER_DIES.toString(), monster.getName()));
            }
        }

        List<Monster> temp = new ArrayList<>();
        for (Monster monster : this.game.getCurrentEnemies()) {
            if (monster.getHp() < 1) {
                temp.add(monster);
            }
        }

        this.game.getCurrentEnemies().removeAll(temp);

        if (this.game.getCurrentEnemies().isEmpty() && this.game.getRoom() > 4 && this.game.getLevel() >= 2) {
            System.out.println(Messages.WIN.toString());
            this.session.stop();
            return;
        }

        if (this.game.getCurrentEnemies().isEmpty()) {
            this.session.setActualState(this.session.getActualState() + 1);
            return;
        }

        this.session.setActualState(3);
    }

}
