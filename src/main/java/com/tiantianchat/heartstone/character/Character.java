package com.tiantianchat.heartstone.character;

import lombok.Data;

/**
 * @author Ramble
 */
@Data
public class Character {
    private String name;
    private String chineseName;
    private int attack;

    /**
     * 当前攻击力
     */
    private int curAttack;

    /**
     * 原始血量
     */
    private int blood;

    /**
     * 当前血量
     */
    private int curBlood;
    private String desc;

    @Override
    public boolean equals(Object c) {
        return c instanceof Character && ((Character) c).getName().equals(this.name);
    }
}
