package edu.kit.informatik.ui;

import java.util.List;

import edu.kit.informatik.ui.messages.Messages;

public class CreateLevel implements GameStates {

    private static final int ARGUMENTS_NUMBER = 2;
    private static final int LIMIT = Integer.MAX_VALUE;

    private final Session session;

    public CreateLevel(Session session) {
        this.session = session;
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
        System.out.println(Messages.SHUFFLE);        
    }

    @Override
    public void execute(List<Integer> arguments) {
        this.session.getGame().initLevel(arguments.get(0), arguments.get(1));
        this.session.setCurrState(this.session.getCurrState() + 1);
    }
}
