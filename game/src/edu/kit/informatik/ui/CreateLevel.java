package edu.kit.informatik.ui;

import java.util.List;

import edu.kit.informatik.model.Game;
import edu.kit.informatik.util.Messages;

public class CreateLevel implements GameStates {

    private static final int ARGUMENTS_NUMBER = 2;
    private static final int LIMIT = Integer.MAX_VALUE;

    private final Session session;
    private final Game game;

    public CreateLevel(Session session, Game game) {
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
        System.out.println(Messages.SHUFFLE.toString());
    }

    @Override
    public void inputMessage() {
        System.out.println(String.format(Messages.ENTER_SEEDS.toString(), LIMIT));        
    }

    @Override
    public void execute(List<Integer> arguments) {
        this.game.initLevel(arguments.get(0), arguments.get(1));
        this.session.setActualState(this.session.getActualState() + 1);
    }
    
}
