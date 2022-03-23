package edu.kit.informatik.model.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Deck<T> {
    private final List<T> o;

    public Deck() {
        this.o = new ArrayList<>();
    }

    public List<T> getList() {
        return this.o;
    }
    
    public void shuffle(int seed) {
        Random random = new Random(seed);
        Collections.shuffle(this.o, random);
    }
}
