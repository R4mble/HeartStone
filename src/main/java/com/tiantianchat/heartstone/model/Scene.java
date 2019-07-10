package com.tiantianchat.heartstone.model;

import com.tiantianchat.heartstone.character.Minion;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Ramble
 */
@Data
public class Scene {

    private ArrayList<Minion> minions;

    public Scene() {
        this.minions = new ArrayList<>();
    }

    public void addLast(Minion minion) {
        this.minions.add(minion);
    }

    @Override
    public String toString() {
        return minions.toString();
    }
}
