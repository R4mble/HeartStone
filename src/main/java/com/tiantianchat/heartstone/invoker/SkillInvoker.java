package com.tiantianchat.heartstone.invoker;

import com.tiantianchat.heartstone.exception.ManaLessException;
import com.tiantianchat.heartstone.exception.ShamanTotemFullException;
import com.tiantianchat.heartstone.model.GameCharacter;
import com.tiantianchat.heartstone.model.dto.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 技能释放器
 */
@Component
public class SkillInvoker {

    private final Skill skill;

    @Autowired
    public SkillInvoker(Skill skill) {
        this.skill = skill;
    }

    // 不需要指定目标的技能
    public void invoke(Profession src) {
        try {
            Method method = skill.getClass().getMethod(src.getSkill(), Profession.class);

            ManaCost manaCost = method.getAnnotation(ManaCost.class);

            if (src.getCurCrystal() < manaCost.value()) {
                throw new ManaLessException();
            }
            method.invoke(skill, src);

            src.setCurCrystal(src.getCurCrystal() - manaCost.value());

        } catch (IllegalAccessException | NoSuchMethodException e) {
            System.out.println(e);
        } catch (InvocationTargetException e) {
            if (e.getTargetException() instanceof ShamanTotemFullException) {
                throw new ShamanTotemFullException();
            }
        }
    }

    // 需要指定一个目标的技能
    public void invoke(Profession src, GameCharacter tar) {
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
