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
        if (this.game.getNrEnemies() == 1) {
            return 1;
        }
        return ARGUMENTS_NUMBER;
    }

    @Override
    public int minArgumentsNumber() {
        if (this.game.getNrEnemies() == 1) {
            return 1;
        }
        return ARGUMENTS_NUMBER;
    }

    @Override
    public int limit() {
        return this.choice.size();
    }

    @Override
    public void message() {
        this.choice = new ArrayList<>();
        int range = 2 * this.game.getNrEnemies();
        if (this.game.getAbilities().size() < 4) {
            range = 3;
        }

        this.choice.addAll(this.game.getAbilities().subList(0, range));
        System.out.println(String.format(Messages.PICK_CARDS.toString(), this.game.getNrEnemies()));
        int counter = 1;
        for (Ability ability : choice) {
            System.out.println(String.format(Messages.ENUMERATION.toString(), counter++, ability.toString()));
        }
    }

    @Override
    public void inputMessage() {
        if (this.game.getNrEnemies() == 1) {
            System.out.println(String.format(Messages.ENTER_NUMBER.toString(), choice.size()));
            return;
        }

        System.out.println(String.format(Messages.ENTER_NUMBERS.toString(), choice.size()));
    }

    @Override
    public void execute(List<Integer> arguments) {
        List<Ability> temp = new ArrayList<>();

        for (Integer value : arguments) {
            for (Ability ability : this.choice) {
                if (this.choice.indexOf(ability) == value - 1) {
                    temp.add(ability);
                }
            }
        }

        this.game.addCards(temp, this.choice);

        for (Integer integer : arguments) {
            Ability ability = this.choice.get(integer - 1);
            System.out.println(String.format(Messages.GET_CARD.toString(), ability.toString()));
        }

        if (this.game.getRoom() > 4) {
            if (this.game.getRuna().getHp() < this.game.getRuna().getMaxHp()
                    && this.game.getRuna().abilities().size() > 1) {
                this.session.setActualState(this.session.getActualState() + 1);
            } else {
                this.session.setActualState(1);
            }

            return;
        }

        if (this.game.getRuna().getHp() < this.game.getRuna().getMaxHp()
                && this.game.getRuna().abilities().size() > 1) {
            this.session.setActualState(this.session.getActualState() + 1);
        } else {
            this.session.setActualState(2);
        }
    }

}
