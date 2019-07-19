package com.tiantianchat.model.heartstone.dto;

import lombok.Data;

/**
 * @author Wangyl
 * @date 2019/7/16
 */
@Data
public class Weapon {
    public String name;
    public int attack;
    public int curAttack;
    public int durability;
    public int curDurability;

    public Weapon(String name, int attack, int durability) {
        this.name = name;
        this.attack = attack;
        this.durability = durability;
    }

    public void setAttack(int attack) {
        this.attack = attack;
        this.curAttack = attack;
    }

    public void setDurability(int durability) {
        this.durability = durability;
        this.curDurability = durability;
    }
}
