package edu.kit.informatik.ui;

import java.util.List;

import edu.kit.informatik.model.Game;
import edu.kit.informatik.model.characters.monster.Monster;
import edu.kit.informatik.util.Messages;

public class SelectTarget implements GameStates {

    private static final int ARGUMENTS_NUMBER = 1;

    private final Session session;
    private final Game game;

    public SelectTarget(Session session, Game game) {
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
        return this.game.getCurrentEnemies().size();
    }

    @Override
    public void message() {
        System.out.println(Messages.SELECT_TARGET.toString());
        int counter = 1;
        for (Monster monster : this.game.getCurrentEnemies()) {
            System.out.println(String.format(Messages.ENUMERATION.toString(), counter++, monster.getName()));
        }
    }

    @Override
    public void inputMessage() {
        System.out.println(String.format(Messages.ENTER_NUMBER.toString(), this.game.getCurrentEnemies().size()));
    }

    @Override
    public void execute(List<Integer> arguments) {
        this.game.selectTarget(arguments.get(0) - 1);
        this.session.setActualState(this.session.getActualState() + 1);
    }
    
}
