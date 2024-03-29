package edu.kit.informatik.ui;

import java.util.List;

import edu.kit.informatik.model.Game;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.util.Messages;

public class Outcome implements GameStates {

    private static final int MAX_ARGUMENTS_NUMBER = 1;
    private static final int MIN_ARGUMENTS_NUMBER = 0;
    private static final int LIMIT = 2;

    private final Session session;
    private final Game game;

    public Outcome(Session session, Game game) {
        this.session = session;
        this.game = game;
    }

    @Override
    public int maxArgumentsNumber() {
        return this.game.getRoom() > 4 || this.game.getRuna().getDice() == 12 ? MIN_ARGUMENTS_NUMBER : MAX_ARGUMENTS_NUMBER;
    }

    @Override
    public int minArgumentsNumber() {
        return this.game.getRoom() > 4 || this.game.getRuna().getDice() == 12 ? MIN_ARGUMENTS_NUMBER : MAX_ARGUMENTS_NUMBER;
    }

    @Override
    public int limit() {
        return this.game.getRoom() > 4 || this.game.getRuna().getDice() == 12 ? 0 : LIMIT;
    }

    @Override
    public void message() {
        if (!(this.game.getRoom() > 4) && this.game.getRuna().getDice() < 12) {
            System.out.println(Messages.CHOOSE_REWARD.toString());
            System.out.println(Messages.ABILITY_CARD.toString());
            System.out.println(Messages.NEXT_DICE.toString());
        }
    }

    @Override
    public void inputMessage() {
        if (!(this.game.getRoom() > 4) && this.game.getRuna().getDice() < 12) {
            System.out.println(String.format(Messages.ENTER_NUMBER.toString(), 2));
        }
    }

    @Override
    public void execute(List<Integer> arguments) {
        if (this.game.getRoom() > 4) {
            this.game.getRuna().upgradeAbility();
            for (Ability ability : this.game.getRuna().classPowers(2)){
                System.out.println(String.format(Messages.GET_CARD.toString(), ability.toString()));
            }

            if (this.game.getRuna().getHp() < this.game.getRuna().getMaxHp() && this.game.getRuna().abilities().size() > 1) {
                this.session.setActualState(this.session.getActualState() + 2);
            } else {
                this.session.setActualState(1);
            }

            this.game.nextLevel();

            return;
        }

        if (this.game.getRuna().getDice() == 12 || arguments.get(0) == 1) {
            this.session.setActualState(this.session.getActualState() + 1);
            return;
        }

        this.game.getRuna().upgradeDice();
        System.out.println(String.format(Messages.DICE_UPGRADE.toString(), this.game.getRuna().getDice()));

        if (this.game.getRuna().getHp() < this.game.getRuna().getMaxHp() && this.game.getRuna().abilities().size() > 1) {
            this.session.setActualState(this.session.getActualState() + 2);
        } else {
            this.session.setActualState(2);
        }

    }

}
