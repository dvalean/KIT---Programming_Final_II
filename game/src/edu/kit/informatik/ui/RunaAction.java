package edu.kit.informatik.ui;

import java.util.List;

import edu.kit.informatik.model.Game;
import edu.kit.informatik.model.abilities.AbilityAction;
import edu.kit.informatik.model.abilities.AbilityType;
import edu.kit.informatik.util.Messages;

public class RunaAction implements GameStates {

    private static final int ARGUMENTS_NUMBER = 0;
    private static final int LIMIT = 0;

    private final Session session;
    private final Game game;

    public RunaAction(Session session, Game game) {
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
        System.out.println(String.format(Messages.CHARACTER_USES.toString(), this.game.getRuna().getName(),
                this.game.getRuna().getIntent()));
    }

    @Override
    public void inputMessage() {
        return;
    }

    @Override
    public void execute(List<Integer> arguments) {
        if (this.game.getRuna().getIntent().getAction() == AbilityAction.ATTACK
                && this.game.getRuna().getIntent().getType() == AbilityType.PHYSICAL) {
            this.session.setActualState(this.session.getActualState() + 1);
        } else {
            this.session.setActualState(this.session.getActualState() + 2);
        }
    }

}
