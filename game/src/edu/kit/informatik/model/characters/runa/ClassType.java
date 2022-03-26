package edu.kit.informatik.model.characters.runa;

import edu.kit.informatik.util.Messages;

public enum ClassType {
    WARRIOR(1),
    MAGE(2),
    PALADIN(3);

    private final int id;

    private ClassType(int id) {
        this.id = id;
    }

    public static ClassType typeById(int id) {
        int counter = 1;

        for (ClassType type : ClassType.values()) {
            if (counter++ == id) {
                return type;
            }
        }

        // TODO: Exception
        throw new IllegalArgumentException();
    }

    @Override
    public String toString() {
        String temp = super.toString().toLowerCase();
        return String.format(Messages.CLASS.toString(), id, temp.substring(0, 1).toUpperCase() + temp.substring(1));
    }
}
