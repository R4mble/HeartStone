package com.tiantianchat.heartstone.model.dto;

import com.tiantianchat.heartstone.model.Card;
import com.tiantianchat.heartstone.model.GameCharacter;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 *
 */
@Data
@NoArgsConstructor
public class Minion implements Card, GameCharacter {
    private String name;
    private int cost;
    private int curCost;
    private int attack;
    private int curAttack;
    private int blood;
    private int curBlood;
    private String battleCry;
    private String profession;

    public Minion(String name, int cost, int attack, int blood, String battleCry) {
        this.name = name;
        this.cost = cost;
        this.attack = attack;
        this.blood = blood;
        this.battleCry = battleCry;
    }
}
