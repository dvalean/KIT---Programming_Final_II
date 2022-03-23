package edu.kit.informatik.ui;

import java.util.List;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.characters.monster.Monsters;
import edu.kit.informatik.model.characters.runa.Runa;
import edu.kit.informatik.ui.messages.Messages;

public class Fight implements GameStates {
    private static final int ARGUMENTS_NUMBER = 1;

    private final Session session;

    public Fight(Session session) {
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
        return this.session.getGame().getRuna().getAbilities().size();
    }

    @Override
    public void message() {
        Runa runa = this.session.getGame().getRuna();
        System.out.println(
                String.format(Messages.RUNA.toString(), runa.getHp(), runa.getMaxHp(), runa.getFp(), runa.getDice()));
        System.out.println(Messages.VS.toString());

        for (Monsters monster : this.session.getGame().getCurrEnemies()) {
            System.out.println(String.format(Messages.MONSTER.toString(), monster.toString(),
                    monster.getMonster().getHp(), monster.getMonster().getFp(), monster.getMonster().getNextMove().toString()));
        }
        System.out.println(Messages.BREAK_LINES.toString());
        System.out.println(Messages.SELECT_CARD.toString());

        int counter = 1;
        for (Ability ability : this.session.getGame().getRuna().getAbilities()) {
            System.out.println(String.format(Messages.CLASS.toString(), counter++, ability.toString()));
        }

        System.out.println(String.format(Messages.ENTER_NUMBER.toString(), this.session.getGame().getRuna().getAbilities().size()));
    }

    @Override
    public void execute(List<Integer> arguments) {
        this.session.getGame().fight(arguments);
    }

}
