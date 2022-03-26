package edu.kit.informatik.ui;

import java.util.ArrayList;
import java.util.List;

import edu.kit.informatik.model.Game;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.util.Messages;

public class NewAbilities implements GameStates {

    private static final int ARGUMENTS_NUMBER = 2;

    private final Session session;
    private final Game game;

    private List<Ability> choice;

    public NewAbilities(Session session, Game game) {
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
        return this.choice.size();
    }

    @Override
    public void message() {
        this.choice = new ArrayList<>();
        this.choice.addAll(this.game.getAbilities().subList(0, 4));
        System.out.println(Messages.PICK_CARDS.toString());
        int counter = 1;
        for (Ability ability : choice) {
            System.out.println(String.format(Messages.ENUMERATION.toString(), counter++, ability.toString()));
        }
    }

    @Override
    public void inputMessage() {
        System.out.println(String.format(Messages.ENTER_NUMBER.toString(), choice.size()));
    }

    @Override
    public void execute(List<Integer> arguments) {
        this.game.addCards(List.of(this.choice.get(arguments.get(0) - 1), this.choice.get(arguments.get(1) - 1)));

        for (Integer integer : arguments) {
            Ability ability = this.choice.get(integer - 1);
            System.out.println(String.format(Messages.GET_CARD.toString(), ability.toString()));
        }

        if (this.game.getRoom() > 4) {
            if (this.game.getRuna().getHp() < this.game.getRuna().getMaxHp()) {
                this.session.setActualState(this.session.getActualState() + 1);
            } else {
                this.session.setActualState(1);
            }

            return;
        }

        if (this.game.getRuna().getHp() < this.game.getRuna().getMaxHp()) {
            this.session.setActualState(this.session.getActualState() + 1);
        } else {
            this.session.setActualState(2);
        }
    }

}
