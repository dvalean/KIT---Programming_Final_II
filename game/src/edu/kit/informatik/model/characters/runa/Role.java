package edu.kit.informatik.model.characters.runa;

import java.util.List;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.runaabilities.*;

public enum Role {
    WARRIOR(List.of(new Thrust(1), new Parry(1)), 1),
    MAGE(List.of(new Focus(1),new Water(1)), 2),
    PALADIN(List.of(new Slash(1), new Reflect(1)), 3);

    private List<Ability> abilities;
    private int roleID;

    private Role(List<Ability> abilities, int roleID) {
        this.abilities = abilities;
        this.roleID = roleID;
    }

    public List<Ability> getAbilities() {
        return this.abilities;
    }

    public int getRoleID() {
        return this.roleID;
    }

    public String format() {
        String temp0 = this.toString().toLowerCase();
        return temp0.substring(0, 1).toUpperCase() + temp0.substring(1);
    }
}
