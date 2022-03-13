package edu.kit.informatik.model;

import edu.kit.informatik.model.characters.runa.Role;
import edu.kit.informatik.model.characters.runa.Runa;

public class Game {
    private Runa runa;

    public Game() {

    }

    public void initialize(int input) {
        Role role = null;
        for (Role r : Role.values()) {
            if (r.getRoleID() == input) {
                role = r;
            }
        }

        this.runa = new Runa(role);
    }
}
