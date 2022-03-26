package edu.kit.informatik.ui;

import java.util.List;

import edu.kit.informatik.model.Game;
import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.AbilityAction;
import edu.kit.informatik.model.characters.monster.Monster;
import edu.kit.informatik.model.characters.runa.Runa;
import edu.kit.informatik.util.Messages;

public class RunaIntent implements GameStates {

    private static final int ARGUMENTS_NUMBER = 1;

    private final Session session;
    private final Game game;

    public RunaIntent(Session session, Game game) {
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
        return this.game.getRuna().abilities().size();
    }

    @Override
    public void message() {
        List<Monster> currentEnemies = this.game.getCurrentEnemies();
        Runa runa = this.game.getRuna();

        System.out.println(Messages.BREAK_LINES.toString());
        System.out.println(
                String.format(Messages.RUNA.toString(), runa.getHp(), runa.getMaxHp(), runa.getFp(), runa.getDice()));

        System.out.println(Messages.VS.toString());

        for (Monster monster : currentEnemies) {
            System.out.println(String.format(Messages.MONSTER.toString(), monster.getName(), monster.getHp(),
                    monster.getFp(), monster.getIntent()));
        }

        System.out.println(Messages.BREAK_LINES.toString());
        System.out.println(Messages.SELECT_ABILITY.toString());

        int counter = 1;
        for (Ability ability : runa.abilities()) {
            System.out.println(String.format(Messages.ENUMERATION.toString(), counter++, ability.toString()));
        }
    }

    @Override
    public void inputMessage() {
        System.out.println(String.format(Messages.ENTER_NUMBER.toString(), this.game.getRuna().abilities().size()));
    }

    @Override
    public void execute(List<Integer> arguments) {
        this.game.getRuna().setIntent(arguments.get(0));

        if (this.game.getCurrentEnemies().size() > 1
                && this.game.getRuna().getIntent().getAction() == AbilityAction.ATTACK) {
            this.session.setActualState(this.session.getActualState() + 1);
        } else {
            this.game.selectTarget(0);
            this.session.setActualState(this.session.getActualState() + 2);
        }
    }

}
