package com.tiantianchat.heartstone.skill;

import com.tiantianchat.heartstone.exception.ManaLessException;
import com.tiantianchat.heartstone.exception.ShamanTotemFullException;
import com.tiantianchat.model.heartstone.GameCharacter;
import com.tiantianchat.model.heartstone.dto.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Wangyl
 * @date 2019/7/19
 */
@Component
public class SkillInvoker {

    @Autowired
    private Skill skill;

    public void invoke(Profession src) throws ManaLessException, ShamanTotemFullException {


        try {
            Method method = skill.getClass().getMethod(src.getSkill(), Profession.class);

            ManaCost manaCost = method.getAnnotation(ManaCost.class);

            if (src.getCurCrystal() < manaCost.value()) {
                throw new ManaLessException();
            }
            method.invoke(skill, src);

            src.setCurCrystal(src.getCurCrystal() - manaCost.value());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println(e);
        }
    }

    public void invoke(Profession src, GameCharacter tar) throws ManaLessException {
        try {
            Method method = skill.getClass().getMethod(src.getSkill(), GameCharacter.class);
            ManaCost manaCost = method.getAnnotation(ManaCost.class);

            if (src.getCurCrystal() < manaCost.value()) {
                throw new ManaLessException();
            }

            method.invoke(skill, tar);

            src.setCurCrystal(src.getCurCrystal() - manaCost.value());

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println(e);
        }
    }
}
