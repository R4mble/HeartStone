package com.tiantianchat.heartstone.skill;

import com.tiantianchat.heartstone.exception.ManaLessException;
import com.tiantianchat.model.heartstone.entity.ProfessionEntity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Wangyl
 * @date 2019/7/19
 */
public class SkillInvoker {

    public static void invokeSkill(ProfessionEntity src) throws ManaLessException {

        Skill skill = new Skill();

        try {
            Method method = skill.getClass().getMethod(src.getSkill(), ProfessionEntity.class);

            ManaCost manaCost = method.getAnnotation(ManaCost.class);

            if (src.getCurCrystal() < manaCost.value()) {
                throw new ManaLessException();
            }

            method.invoke(skill, src);

            src.setCurCrystal(src.getCrystal() - manaCost.value());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println(e);
        }
    }

//    public void invokeSkill(ProfessionEntity src, Character tar) throws ManaLessException {
//        try {
//            Skill skill = new Skill();
//            Method method = skill.getClass().getMethod(this.skill, Hero.class, Character.class);
//            ManaCost manaCost = method.getAnnotation(ManaCost.class);
//
//            if (curCrystal < manaCost.value()) {
//                throw new ManaLessException();
//            }
//
//            method.invoke(skill, this, character);
//
//            curCrystal = (curCrystal - manaCost.value());
//
//        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//            System.out.println(e);
//        }
//    }
}
