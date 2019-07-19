package com.tiantianchat.model.heartstone.dto;

import com.tiantianchat.model.heartstone.Card;
import com.tiantianchat.model.heartstone.GameCharacter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Wangyl
 * @date 2019/7/19
 */
@Data
@NoArgsConstructor
public class Profession implements GameCharacter {
    private String name;
    private String skill;
    private int attack;
    private int blood = 30;
    private int curBlood = 30;
    private int armor;
    private int crystal;
    private int curCrystal;
    private List<Card> handCard = new LinkedList<>();
    private List<Minion> scene = new LinkedList<>();
    private List<Card> cardLibrary = new LinkedList<>();

    public Profession(String name, String skill) {
        this.name = name;
        this.skill = skill;
    }

    public void setCrystal(int cry) {
        crystal = cry;
        curCrystal = cry;
    }

    public int getHealth() {
        return curBlood + armor;
    }
}
