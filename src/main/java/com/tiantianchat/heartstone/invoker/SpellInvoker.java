package com.tiantianchat.heartstone.invoker;

import com.tiantianchat.heartstone.exception.ManaLessException;
import com.tiantianchat.heartstone.model.GameCharacter;
import com.tiantianchat.heartstone.model.dto.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 法术释放器
 */
@Component
public class SpellInvoker {

    private final Spells spell;

    @Autowired
    public SpellInvoker(Spells spell) {
        this.spell = spell;
    }

    // 不需要指定目标的法术
    public void invoke(Profession src, String spellName) throws ManaLessException {

        try {
            Method method = spell.getClass().getMethod(spellName, Profession.class);

            ManaCost manaCost = method.getAnnotation(ManaCost.class);

            if (src.getCurCrystal() < manaCost.value()) {
                throw new ManaLessException();
            }

            method.invoke(spell, src);

            src.setCurCrystal(src.getCurCrystal() - manaCost.value());

        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            System.out.println(e);
        }
    }

    // 需要指定一个目标的法术
    public void invoke(Profession src, String spellName, GameCharacter tar) throws ManaLessException {
        try {
            Method method = spell.getClass().getMethod(spellName, GameCharacter.class);
            ManaCost manaCost = method.getAnnotation(ManaCost.class);

            if (src.getCurCrystal() < manaCost.value()) {
                throw new ManaLessException();
            }

            method.invoke(spell, tar);

            src.setCurCrystal(src.getCurCrystal() - manaCost.value());

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            System.out.println(e);
        }
    }
}
