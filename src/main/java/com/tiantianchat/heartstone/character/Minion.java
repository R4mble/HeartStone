package com.tiantianchat.heartstone.character;

import com.tiantianchat.heartstone.model.Attribute;
import lombok.Data;

/**
 * @author Ramble
 */
@Data
public class Minion extends Character {

    private Attribute[] attributes;

    @Override
    public String toString() {
        return this.getChineseName();
    }

    @Override
    public boolean equals(Object c) {
        return c instanceof Minion && ((Minion) c).getName().equals(this.getName());
    }
}
