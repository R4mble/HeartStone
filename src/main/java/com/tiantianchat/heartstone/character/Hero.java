package com.tiantianchat.heartstone.character;

import com.tiantianchat.heartstone.exception.ManaLessException;
import com.tiantianchat.heartstone.model.Card;
import com.tiantianchat.heartstone.model.CardLibrary;
import com.tiantianchat.heartstone.model.HandCard;
import com.tiantianchat.heartstone.model.Scene;
import com.tiantianchat.heartstone.skill.ManaCost;
import com.tiantianchat.heartstone.skill.Skill;
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

    public int getHealth() {
        return this.getCurBlood() + this.getArmor();
    }

    public void invokeSkill() throws ManaLessException {
        try {
            Skill skill = new Skill();
            Method method = skill.getClass().getMethod(this.skill, Hero.class);
            ManaCost manaCost = method.getAnnotation(ManaCost.class);

            if (this.getCrystal() < manaCost.value()) {
                throw new ManaLessException();
            }

            method.invoke(skill, this);

            this.setCrystal(this.getCrystal() - manaCost.value());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println(e);
        }
    }

    public void invokeSkill(Character character) throws ManaLessException {
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
}
