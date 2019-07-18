package com.tiantianchat.heartstone.character;

import lombok.Data;

/**
 * @author Ramble
 */
public class Character {
    public String name;
    public int attack;

    /**
     * 当前攻击力
     */
    public int curAttack;

    /**
     * 原始血量
     */
    public int blood;

    /**
     * 当前血量
     */
    public int curBlood;

    public String desc;

    @Override
    public boolean equals(Object c) {
        return c instanceof Character && ((Character) c).name.equals(this.name);
    }

    public void setBlood(int blood) {
        this.blood = blood;
        this.curBlood = blood;
    }

    public void setAttack(int attack) {
        this.attack = attack;
        this.curAttack = attack;
    }
}
