package edu.kit.informatik.ui;

import java.util.List;

import edu.kit.informatik.model.Game;
import edu.kit.informatik.util.Messages;

public class RunaEvaluator implements GameStates {

    private static final int ARGUMENTS_NUMBER = 0;
    private static final int LIMIT = 0;

    private final Session session;
    private final Game game;

    public RunaEvaluator(Session session, Game game) {
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
        int action = this.game.runaEvaluator();
        if (action > 0) {
            System.out.println(String.format(Messages.CHARACTER_TAKE_DMG.toString(),
                    this.game.getTarget().getName(), action, this.game.getRuna().getIntent().getType().toString()));
        }

        if (this.game.getTarget().getHp() < 1) {
            System.out.println(String.format(Messages.CHARACTER_DIES.toString(), this.game.getTarget().getName()));
            this.game.deleteTarget();
        }

        if (this.game.getCurrentEnemies().isEmpty() && this.game.getRoom() > 4 && this.game.getLevel() > 2) {
            System.out.println(Messages.WIN.toString());
            this.session.stop();
            return;
        }

        if (this.game.getCurrentEnemies().isEmpty()) {            
            this.session.setActualState(this.session.getActualState() + 2);
            return;
        }

        this.session.setActualState(this.session.getActualState() + 1);
    }
    
}
