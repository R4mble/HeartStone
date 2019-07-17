package com.tiantianchat.heartstone.skill;

import com.tiantianchat.heartstone.character.Hero;
import com.tiantianchat.heartstone.character.Minion;
import com.tiantianchat.heartstone.model.Card;
import com.tiantianchat.heartstone.character.Character;
/**
 * @author Wangyl
 * @date 2019/7/10
 */
public class Spell implements Card {

    @ManaCost(value = 0, desc = "幸运币")
    public void luckyCoin(Hero hero) {
        hero.curCrystal = (hero.curCrystal + 1);
    }

    @ManaCost(value = 4, desc = "火球术")
    public void fileBall(Hero hero, Character character) {
        character.curBlood = (character.curBlood - 6);
    }

    @ManaCost(value = 10, desc = "炎爆")
    public void pyroblast(Hero hero, Character character) {
        character.curBlood = (character.curBlood - 10);
    }

    @ManaCost(value = 3, desc = "暗影箭")
    public void shadowArrow(Hero hero, Minion minion) {
        minion.curBlood = (minion.curBlood - 4);
    }
}
