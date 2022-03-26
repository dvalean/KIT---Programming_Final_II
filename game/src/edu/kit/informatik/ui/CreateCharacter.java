package edu.kit.informatik.ui;

import java.util.List;

import edu.kit.informatik.model.Game;
import edu.kit.informatik.model.characters.runa.ClassType;
import edu.kit.informatik.util.Messages;

public class CreateCharacter implements GameStates {

    private static final int ARGUMENTS_NUMBER = 1;
    private static final int LIMIT = 3;

    private final Session session;
    private final Game game;

    public CreateCharacter(Session session, Game game) {
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
        System.out.println(Messages.WELCOME.toString());
        System.out.println(Messages.SELECT_CLASS.toString());

        for (ClassType type : ClassType.values()) {
            System.out.println(type.toString());
        }
    }

    @Override
    public void inputMessage() {
        System.out.println(String.format(Messages.ENTER_NUMBER.toString(), ClassType.values().length));
    }

    @Override
    public void execute(List<Integer> arguments) {
        this.game.initGame(arguments.get(0).intValue());
        this.session.setActualState(this.session.getActualState() + 1);
    }

}
