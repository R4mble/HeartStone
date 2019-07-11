package com.tiantianchat.heartstone.model;

import com.tiantianchat.heartstone.character.Character;
import com.tiantianchat.heartstone.character.Minion;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ramble
 */
@Data
public class Scene {

    private List<Minion> minions;

    public Scene() {
        this.minions = new ArrayList<>();
    }

    public void addLast(Minion minion) {
        this.minions.add(minion);
    }

    public boolean exist(String minionName) {
        return minions.stream()
                .anyMatch(m -> m.getChineseName().equals(minionName) || m.getName().equals(minionName));
    }

    @Override
    public String toString() {
        return minions.toString();
    }

    public int size() {
        return minions.size();
    }

    public void remove(Minion m) {
        minions = minions.stream().filter(minion -> minion != m).collect(Collectors.toList());
    }
}
