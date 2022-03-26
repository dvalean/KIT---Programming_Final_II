package edu.kit.informatik.ui;

import java.util.ArrayList;
import java.util.List;

import edu.kit.informatik.model.Game;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.util.Messages;

public class Healing implements GameStates {

    private static final int MAX_ARGUMENTS_NUMBER = 2;
    private static final int MIN_ARGUMENTS_NUMBER = 0;

    private final Session session;
    private final Game game;

    public Healing(Session session, Game game) {
        this.session = session;
        this.game = game;
    }

    @Override
    public int maxArgumentsNumber() {
        return MAX_ARGUMENTS_NUMBER;
    }

    @Override
    public int minArgumentsNumber() {
        return MIN_ARGUMENTS_NUMBER;
    }

    @Override
    public int limit() {
        return this.game.getRuna().abilities().size();
    }

    @Override
    public void message() {
        System.out.println(String.format(Messages.HEALING.toString(), this.game.getRuna().getHp(),
                this.game.getRuna().getMaxHp()));
        int counter = 1;
        for (Ability ability : this.game.getRuna().abilities()) {
            System.out.println(String.format(Messages.ENUMERATION.toString(), counter++, ability.toString()));
        }
    }

    @Override
    public void inputMessage() {
        System.out.println(String.format(Messages.ENTER_NUMBERS.toString(), this.game.getRuna().abilities().size()));
    }

    @Override
    public void execute(List<Integer> arguments) {
        this.game.getRuna().heal(10 * arguments.size());
        System.out.println(String.format(Messages.HEAL.toString(), 10 * arguments.size()));
        List<Ability> remove = new ArrayList<>();
        for (Integer index : arguments) {
            remove.add(this.game.getRuna().abilities().get(index - 1));
        }

        this.game.getRuna().removeAbility(remove);

        if (this.game.getRoom() > 4) {
            this.session.setActualState(1);
            return;
        }

        this.session.setActualState(2);
    }

}
