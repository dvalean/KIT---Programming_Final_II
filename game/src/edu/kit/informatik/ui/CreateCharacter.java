package edu.kit.informatik.ui;

import java.util.List;

import edu.kit.informatik.model.characters.runa.Type;
import edu.kit.informatik.ui.messages.Messages;

public class CreateCharacter implements GameStates {
    private static final int ARGUMENTS_NUMBER = 1;
    private static final int LIMIT = 3;

    private final Session session;

    public CreateCharacter(Session session) {
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
        System.out.println(Messages.WELCOME.toString());
        System.out.println(Messages.SELECT_CLASS.toString());

        int counter = 1;
        for (Type type : Type.values()) {
            System.out.println(String.format(Messages.CLASS.toString(), counter++, type.toString()));
        }

        System.out.println(String.format(Messages.ENTER_NUMBER.toString(), Type.values().length));
    }

    @Override
    public void execute(List<Integer> arguments) {
        this.session.getGame().initGame(arguments.get(0).intValue());
        this.session.setCurrState(this.session.getCurrState() + 1);
    }
}
