package edu.kit.informatik.ui;

import java.util.List;

import edu.kit.informatik.model.Game;
import edu.kit.informatik.util.Messages;

public class RunaRoll implements GameStates {

    private static final int ARGUMENTS_NUMBER = 1;

    private final Session session;
    private final Game game;

    public RunaRoll(Session session, Game game) {
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
        return this.game.getRuna().getDice();
    }

    @Override
    public void message() {
        return;
    }

    @Override
    public void inputMessage() {
        System.out.println(String.format(Messages.ENTER_DICE_ROLL.toString(), this.game.getRuna().getDice()));
    }

    @Override
    public void execute(List<Integer> arguments) {
        this.game.getRuna().setRoll(arguments.get(0));
        this.session.setActualState(this.session.getActualState() + 1);
    }

}
