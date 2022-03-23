package edu.kit.informatik.model.characters.runa;

import java.util.List;

import edu.kit.informatik.model.abilities.Ability;
import edu.kit.informatik.model.abilities.runaabilities.Focus;
import edu.kit.informatik.model.abilities.runaabilities.Parry;
import edu.kit.informatik.model.abilities.runaabilities.Reflect;
import edu.kit.informatik.model.abilities.runaabilities.Slash;
import edu.kit.informatik.model.abilities.runaabilities.Thrust;
import edu.kit.informatik.model.abilities.runaabilities.Water;

public enum Type {

    WORRIOR,
    MAGE,
    PALADIN;

    @Override
    public String toString() {
        String temp0 = super.toString().toLowerCase();
        return temp0.substring(0, 1).toUpperCase() + temp0.substring(1);
    }

    public List<Ability> typePowers(int level) {
        switch (this) {
            case WORRIOR:
                return List.of(new Thrust(level), new Parry(level));

            case MAGE:
                return List.of(new Focus(level), new Water(level));

            case PALADIN:
                return List.of(new Slash(level), new Reflect(level));

            default:
                return null;
        }
    }

    public static Type typeByNr(int id) {
        int i = 1;
        for (Type type : Type.values()) {
            if (i++ == id) {
                return type;
            }
        }

        return null;
    }

}
