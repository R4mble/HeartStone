package com.tiantianchat.heartstone.character;

import com.tiantianchat.heartstone.exception.ManaLessException;
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
        return this.getCurBlood() + this.getArmor();
    }

    public void invokeSkill() {
        try {
            Skill skill = new Skill();
            Method method = skill.getClass().getMethod(this.skill, Hero.class);
            ManaCost manaCost = method.getAnnotation(ManaCost.class);

            if (this.getCrystal() < manaCost.value()) {
                throw new ManaLessException();
            }

            method.invoke(skill, this);

            this.setCrystal(this.getCrystal() - manaCost.value());
        } catch (Exception e) {
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
}
