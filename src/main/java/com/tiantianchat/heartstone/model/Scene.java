package com.tiantianchat.heartstone.model;

import com.tiantianchat.heartstone.minion.Minion;
import com.tiantianchat.heartstone.minion.Reporter;

import java.util.LinkedList;

/**
 * @author Ramble
 */
public class Scene {

    private LinkedList<Minion> minions;

    public Scene() {
        this.minions = new LinkedList<>();
    }

    public void addLast(Minion minion) {
        this.minions.addLast(minion);
    }

    @Override
    public String toString() {
        return minions.toString();
    }
}
