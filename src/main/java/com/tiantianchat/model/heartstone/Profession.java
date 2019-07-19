package com.tiantianchat.model.heartstone;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author Wangyl
 * @date 2019/7/19
 */
@Data
public class Profession implements Character {
    private int id;
    private String name;
    private String skill;
    private int attack;
    private int blood;
    private int curBlood;
    private int armor;
    private int crystal;
    private int curCrystal;
    private Card[] handCard;
    private Card[] cardLibrary;

    public void setCrystal(int cry) {
        crystal = cry;
        curCrystal = cry;
    }

    public int getHealth() {
        return curBlood + armor;
    }
}
