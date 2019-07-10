package com.tiantianchat.heartstone.character;

import com.tiantianchat.heartstone.model.Attribute;
import com.tiantianchat.heartstone.model.Card;
import lombok.Data;

/**
 * @author Ramble
 */
@Data
public class Minion extends Character implements Card {

    private Attribute[] attributes;
    private int cost;

    @Override
    public String toString() {
        return this.getChineseName();
    }

    @Override
    public boolean equals(Object c) {
        return c instanceof Minion && ((Minion) c).getName().equals(this.getName());
    }


}
