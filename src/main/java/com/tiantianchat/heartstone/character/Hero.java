package com.tiantianchat.heartstone.character;

import com.tiantianchat.heartstone.exception.AttackZeroException;
import com.tiantianchat.heartstone.exception.ManaLessException;
import com.tiantianchat.heartstone.model.*;
import com.tiantianchat.heartstone.skill.ManaCost;
import com.tiantianchat.heartstone.skill.Skill;
import com.tiantianchat.heartstone.skill.Spell;
import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Ramble
 */
@Data
public class Hero extends Character {

    /**
     * 护甲
     */
    private int armor = 0;

    /**
     * 水晶
     */
    private int crystal;

    private int curCrystal;

    /**
     * 英雄技能
     */
    private String skill;

    /**
     * 场面
     */
    Scene scene = new Scene();

    /**
     * 手牌
     */
    HandCard handCard = new HandCard();

    /**
     * 牌库
     */
    CardLibrary cardLibrary = new CardLibrary();

    public Hero() {
        this.setBlood(30);
        this.setCurBlood(30);
    }

    public void setCrystal(int crystal) {
        this.crystal = crystal;
        this.curCrystal = crystal;
    }

    public int getHealth() {
        return this.getCurBlood() + this.getArmor();
    }

    public void invokeSkill() throws ManaLessException {
        try {
            Skill skill = new Skill();
            Method method = skill.getClass().getMethod(this.skill, Hero.class);
            ManaCost manaCost = method.getAnnotation(ManaCost.class);

            if (this.getCurCrystal() < manaCost.value()) {
                throw new ManaLessException();
            }

            method.invoke(skill, this);

            this.setCurCrystal(this.getCurCrystal() - manaCost.value());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println(e);
        }
    }

    public void invokeSkill(Character character) throws ManaLessException {
        try {
            Skill skill = new Skill();
            Method method = skill.getClass().getMethod(this.skill, Hero.class, Character.class);
            ManaCost manaCost = method.getAnnotation(ManaCost.class);

            if (this.getCurCrystal() < manaCost.value()) {
                throw new ManaLessException();
            }

            method.invoke(skill, this, character);

            this.setCurCrystal(this.getCurCrystal() - manaCost.value());

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println(e);
        }
    }

    public void castSpell(String spellName) throws ManaLessException {
        try {
            Spell spell = new Spell();
            Method method = spell.getClass().getMethod(spellName, Hero.class);
            ManaCost manaCost = method.getAnnotation(ManaCost.class);

            if (this.getCurCrystal() < manaCost.value()) {
                throw new ManaLessException();
            }

            method.invoke(spell, this);

            this.setCurCrystal(this.getCurCrystal() - manaCost.value());

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println(e);
        }
    }

    public void castSpell(String spellName, Character character) throws ManaLessException {
        try {
            Skill skill = new Skill();
            Method method = skill.getClass().getMethod(this.skill, Hero.class, Character.class);
            ManaCost manaCost = method.getAnnotation(ManaCost.class);

            if (this.getCrystal() < manaCost.value()) {
                throw new ManaLessException();
            }

            method.invoke(skill, this, character);

            this.setCrystal(this.getCrystal() - manaCost.value());

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
        if (this.handCard.exist(minion.getName())) {
            handCard.remove(minion);
            scene.addLast(minion);
        }
    }

    public void attack(Character src, Character tar) throws AttackZeroException {
        if (src.getCurAttack() < 1) {
            throw new AttackZeroException();
        }

        src.setCurBlood(src.getCurBlood() - tar.getCurAttack());
        tar.setCurBlood(tar.getCurBlood() - src.getCurAttack());

        if (src.getCurBlood() < 1) {
            if (src instanceof Hero) {
                Battle.over(this);
            } else {
                scene.remove((Minion)src);
            }
        }

        if (tar.getCurBlood() < 1) {
            if (tar instanceof Hero) {
                Battle.over((Hero)tar);
            } else {
                Battle.killMinion((Minion)src);
            }
        }
    }
}
