package edu.kit.informatik.ui;

import java.util.List;

public interface GameStates {

    public abstract int maxArgumentsNumber();

    public abstract int minArgumentsNumber();

    public abstract int limit();

    public abstract void message();

    public abstract void inputMessage();
    
    public abstract void execute(List<Integer> arguments);
}