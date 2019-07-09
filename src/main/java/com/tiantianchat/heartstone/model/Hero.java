package com.tiantianchat.heartstone.model;

import com.tiantianchat.heartstone.skill.Skill;
import lombok.Data;
import com.tiantianchat.heartstone.minion.Character;
/**
 * @author Ramble
 */
@Data
public class Hero extends Character {

    // 护甲
    private int armor = 0;

    // 水晶
    private int crystal;


    private String skill;

    Scene scene = new Scene();

    public Hero() {
        this.setBlood(30);
    }

    public int getHealth() {
        return this.getBlood() + this.getArmor();
    }
}
