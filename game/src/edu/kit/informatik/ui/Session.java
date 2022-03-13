package edu.kit.informatik.ui;

import java.util.Scanner;

import edu.kit.informatik.model.characters.runa.Role;
import edu.kit.informatik.ui.util.Messages;

public class Session {
    private static final String SEPARATOR = ",";
    private static final String QUIT = "quit";

    private final Scanner scanner;
    private boolean running;

    public Session() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        this.running = true;

        System.out.println(Messages.WELCOME);
        System.out.println(Messages.SELECT_CLASS);

        for (Role role : Role.values()) {
            System.out.println(String.format(Messages.ENUMERATION, role.getRoleID(), role.toString()));
        }

        System.out.println(String.format(Messages.ENTER_NUMBER, Role.values().length));

        while (this.running) {
            String input = this.scanner.nextLine();
            if (input == null) {
                return;
            }
            input(input);
        }
    }

    private void input(String input) {
        if (input.equals(QUIT)) {
            stop();
            return;
        }
    }

    public void stop() {
        this.running = false;
    }
}
