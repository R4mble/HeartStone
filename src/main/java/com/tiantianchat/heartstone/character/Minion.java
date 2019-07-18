package com.tiantianchat.heartstone.character;

import com.tiantianchat.heartstone.model.Attribute;
import com.tiantianchat.heartstone.model.Card;
import lombok.Data;

/**
 * @author Ramble
 */
public class Minion extends Character implements Card {

    public Attribute[] attributes;
    public int cost;

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object c) {
        return c instanceof Minion && ((Minion) c).name.equals(this.name);
    }


}
