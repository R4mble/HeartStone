package com.tiantianchat.heartstone.character;

import com.tiantianchat.heartstone.exception.AttackZeroException;
import com.tiantianchat.heartstone.exception.ManaLessException;
import com.tiantianchat.heartstone.model.*;
import com.tiantianchat.heartstone.skill.ManaCost;
import com.tiantianchat.heartstone.skill.Skill;
import com.tiantianchat.heartstone.skill.Spell;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Ramble
 */
public class Hero extends Character {

    /**
     * 护甲
     */
    public int armor = 0;

    /**
     * 水晶
     */
    public int crystal = 0;

    public int curCrystal;

    /**
     * 武器
     */
    public Weapon weapon;


    /**
     * 英雄技能
     */
    public String skill;

    /**
     * 场面
     */
    public Scene scene = new Scene();

    /**
     * 手牌
     */
    public HandCard handCard = new HandCard();

    /**
     * 牌库
     */
    public CardLibrary cardLibrary;
    public String chineseName;

    public Hero() {
        this.blood = 30;
        this.curBlood = 30;
    }

    public Hero(Hero hero) {
        skill = hero.skill;
        name = hero.name;
        chineseName = hero.chineseName;
    }

    public void setCrystal(int crystal) {
        this.crystal = crystal;
        this.curCrystal = crystal;
    }

    public int getHealth() {
        return curBlood + armor;
    }



    // 释放技能
    public void castSpell(String spellName) throws ManaLessException {
        try {
            Spell spell = new Spell();
            Method method = spell.getClass().getMethod(spellName, Hero.class);
            ManaCost manaCost = method.getAnnotation(ManaCost.class);

            if (this.curCrystal < manaCost.value()) {
                throw new ManaLessException();
            }

            method.invoke(spell, this);

            curCrystal = (curCrystal - manaCost.value());

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println(e);
        }
    }

    public void castSpell(String spellName, Character character) throws ManaLessException {
        try {
            Skill skill = new Skill();
            Method method = skill.getClass().getMethod(this.skill, Hero.class, Character.class);
            ManaCost manaCost = method.getAnnotation(ManaCost.class);

            if (curCrystal < manaCost.value()) {
                throw new ManaLessException();
            }

            method.invoke(skill, this, character);

            this.setCrystal(curCrystal - manaCost.value());

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println(e);
        }
    }


    public void drawCard(int cardNum) {
        while (cardNum != 0) {
            Card card = this.cardLibrary.drawCard();
            handCard.addLast(card);
            cardNum--;
        }
    }

    public void useMinion(Minion minion) {

        if (curCrystal < minion.cost) {
            throw new ManaLessException();
        }




        if (this.handCard.exist(minion)) {
            handCard.remove(minion);
            scene.addLast(minion);
        }
    }

    public void attack(Character src, Character tar) throws AttackZeroException {
        if (src.curAttack < 1) {
            throw new AttackZeroException();
        }

        src.curBlood = (src.curBlood - tar.curAttack);
        tar.curBlood = (tar.curBlood - src.curBlood);

        if (src.curBlood < 1) {
            if (src instanceof Hero) {
                Battle.over(this);
            } else {
                scene.remove((Minion) src);
            }
        }

        if (tar.curBlood < 1) {
            if (tar instanceof Hero) {
                Battle.over((Hero) tar);
            } else {
                Battle.killMinion((Minion) src);
            }
        }
    }
}
