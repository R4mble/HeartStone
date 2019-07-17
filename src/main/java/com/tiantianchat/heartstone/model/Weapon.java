package com.tiantianchat.heartstone.model;

import lombok.Data;

/**
 * @author Wangyl
 * @date 2019/7/16
 */
@Data
public class Weapon {
    private String name;
    private int attack;
    private int curAttack;
    private int durability;
    private int curDurability;

    public void setAttack(int attack) {
        this.attack = attack;
        this.curAttack = attack;
    }

    public void setDurability(int durability) {
        this.durability = durability;
        this.curDurability = durability;
    }
}
