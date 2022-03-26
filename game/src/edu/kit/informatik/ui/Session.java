package edu.kit.informatik.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import edu.kit.informatik.model.Game;

public class Session {

    private static final String QUIT = "quit";
    private static final String SEPARATOR = ",";

    private final Scanner scanner;
    private boolean validInput;
    private boolean running;

    private final Game game;

    private final List<GameStates> states;
    private int actualState;

    public Session() {
        this.scanner = new Scanner(System.in);
        this.game = new Game();

        this.states = new ArrayList<>();
        initStates();
        this.actualState = 0;
    }

    public void setActualState(int actualState) {
        this.actualState = actualState;
    }

    public int getActualState() {
        return this.actualState;
    }

    private void initStates() {
        this.states.add(new CreateCharacter(this, this.game));
        this.states.add(new CreateLevel(this, this.game));
        this.states.add(new CreateRoom(this, this.game));
        this.states.add(new RunaIntent(this, this.game));
        this.states.add(new SelectTarget(this, this.game));
        this.states.add(new RunaAction(this, this.game));
        this.states.add(new RunaRoll(this, this.game));
        this.states.add(new RunaEvaluator(this, this.game));
        this.states.add(new MonsterEvaluator(this, this.game));
        this.states.add(new Outcome(this, this.game));
        this.states.add(new NewAbilities(this, this.game));
        this.states.add(new Healing(this, this.game));
    }

    public void start() {
        this.running = true;
        this.validInput = true;

        while (this.running) {
            if (this.validInput) {
                this.states.get(this.actualState).message();
                this.validInput = false;
            }

            this.states.get(this.actualState).inputMessage();

            if (this.states.get(this.actualState).maxArgumentsNumber() != 0) {
                String input = this.scanner.nextLine();
                if (input.equals(QUIT)) {
                    stop();
                    return;
                }

                input(input);
            } else {
                this.validInput = true;
                this.states.get(this.actualState).execute(List.of());
            }
        }
    }

    private void input(String input) {
        List<String> split = List.of(input.split(SEPARATOR));

        try {
            List<Integer> converted = split.stream().map(each -> Integer.parseInt(each)).collect(Collectors.toList());

            if (converted.size() < this.states.get(this.actualState).minArgumentsNumber()
                    || converted.size() > this.states.get(this.actualState).maxArgumentsNumber()) {
                return;
            }

            Optional<Integer> empty = Optional.empty();
            if (converted.stream().filter(each -> each.intValue() > this.states.get(this.actualState).limit())
                    .findAny() != empty) {
                return;
            }

            this.validInput = true;
            this.states.get(this.actualState).execute(converted);
        } catch (NumberFormatException e) {
            // TODO: handle exception
            return;
        }
    }

    public void stop() {
        this.running = false;
    }

}
