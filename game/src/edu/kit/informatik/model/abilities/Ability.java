package edu.kit.informatik.model.abilities;

import edu.kit.informatik.model.characters.Character;

public abstract class Ability {
    private static final String REGEX = "%s(%d)";

    private final int level;

    protected String name;
    protected Action action;
    protected Type type;

    public Ability(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public Action getAction() {
        return this.action;
    }

    public Type getType() {
        return this.type;
    }

    public abstract void execute(Character attacker, Character defender);

    @Override
    public String toString() {
        return String.format(REGEX, this.name, this.level);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        Ability a = (Ability) o;
        if (this.name.equals(a.name)) {
            return true;
        }

        return false;
    }
    
}
