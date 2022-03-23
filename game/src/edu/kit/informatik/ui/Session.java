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
    private final List<GameStates> gameStates;
    private int currState;
    private boolean running;
    private final Game game;

    private boolean success;

    public Session() {
        this.scanner = new Scanner(System.in);
        this.gameStates = new ArrayList<>();
        this.currState = 0;
        this.game = new Game();

        this.gameStates.add(new CreateCharacter(this));
        this.gameStates.add(new CreateLevel(this));
        this.gameStates.add(new CreateRoom(this));
        this.gameStates.add(new Fight(this));
    }

    public void setCurrState(int currState) {
        this.currState = currState;
    }

    public int getCurrState() {
        return this.currState;
    }

    public Game getGame() {
        return this.game;
    }

    public void start() {
        this.running = true;
        this.success = true;
        while (this.running) {
            if (this.success) {
                this.gameStates.get(currState).message();
                this.success = false;
            }

            if (this.gameStates.get(currState).maxArgumentsNumber() != 0) {
                String input = this.scanner.nextLine();
                if (input.equals(QUIT)) {
                    stop();
                    return;
                }
                input(input);
            } else {
                this.success = true;
                this.gameStates.get(this.currState).execute(List.of());
            }
        }
    }

    private void input(String input) {
        List<String> split = List.of(input.split(SEPARATOR));

        try {
            List<Integer> converted = split.stream().map(each -> Integer.parseInt(each)).collect(Collectors.toList());

            if (converted.size() < this.gameStates.get(currState).minArgumentsNumber()) {
                return;
            }

            if (converted.size() > this.gameStates.get(currState).maxArgumentsNumber()) {
                return;
            }

            Optional<Integer> empty = Optional.empty();
            if (converted.stream().filter(each -> each > this.gameStates.get(this.currState).limit())
                    .findAny() != empty) {
                return;
            }

            this.success = true;
            this.gameStates.get(this.currState).execute(converted);
        } catch (NumberFormatException e) {
            return;
        }
    }

    public void stop() {
        this.running = false;
    }
}
