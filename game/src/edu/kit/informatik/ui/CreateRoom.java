package edu.kit.informatik.ui;

import java.util.List;

import edu.kit.informatik.model.Game;
import edu.kit.informatik.util.Messages;

public class CreateRoom implements GameStates {

    private static final int ARGUMENTS_NUMBER = 0;
    private static final int LIMIT = 0;

    private final Session session;
    private final Game game;

    public CreateRoom(Session session, Game game) {
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
        System.out.println(String.format(Messages.ENTER_ROOM.toString(), this.game.getRoom(),
                this.game.getLevel()));
    }

    @Override
    public void inputMessage() {

    }

    @Override
    public void execute(List<Integer> arguments) {
        this.game.initRoom();
        this.session.setActualState(this.session.getActualState() + 1);
    }

}
