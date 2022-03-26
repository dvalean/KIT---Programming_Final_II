package edu.kit.informatik.ui;

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
            System.out
                    .println(String.format(Messages.CHARACTER_USES.toString(), monster.getName(), monster.getIntent()));
            int action = this.game.monsterEvaluator(monster);
            if (action > 0) {
                System.out.println(String.format(Messages.CHARACTER_TAKE_DMG.toString(),
                        this.game.getRuna().getName(), action, monster.getIntent().getType().toString()));
            }

            if (this.game.getRuna().getHp() < 1) {
                this.session.stop();
                return;
            }
        }

        this.session.setActualState(3);
    }

}
