package com.tiantianchat.model.heartstone.dto;

import com.tiantianchat.model.heartstone.Card;
import com.tiantianchat.model.heartstone.GameCharacter;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Wangyl
 * @date 2019/7/19
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
    
    public Minion(String name, int cost, int attack, int blood) {
        this.name = name;
        this.cost = cost;
        this.attack = attack;
        this.blood = blood;
    }
}
