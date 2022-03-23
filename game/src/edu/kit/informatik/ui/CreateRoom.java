package edu.kit.informatik.ui;

import java.util.List;

import edu.kit.informatik.ui.messages.Messages;

public class CreateRoom implements GameStates {

    private final Session session;

    public CreateRoom(Session session) {
        this.session = session;
    }

    @Override
    public int maxArgumentsNumber() {
        return 0;
    }

    @Override
    public int minArgumentsNumber() {
        return 0;
    }

    @Override
    public int limit() {
        return 0;
    }

    @Override
    public void message() {
        System.out.println(String.format(Messages.ENTER_ROOM.toString(), this.session.getGame().getRoom(),
                this.session.getGame().getLevel()));
        System.out.println(Messages.BREAK_LINES.toString());
    }

    @Override
    public void execute(List<Integer> arguments) {
        this.session.getGame().initRoom();
        this.session.setCurrState(this.session.getCurrState() + 1);
    }

}
