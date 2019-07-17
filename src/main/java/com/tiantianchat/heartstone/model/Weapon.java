package com.tiantianchat.heartstone.model;

import lombok.Data;

/**
 * @author Wangyl
 * @date 2019/7/16
 */
public class Weapon {
    public String name;
    public int attack;
    public int curAttack;
    public int durability;
    public int curDurability;

    public void setAttack(int attack) {
        this.attack = attack;
        this.curAttack = attack;
    }

    public void setDurability(int durability) {
        this.durability = durability;
        this.curDurability = durability;
    }
}
