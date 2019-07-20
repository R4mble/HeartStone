package com.tiantianchat.heartstone.invoker;

import com.tiantianchat.heartstone.constant.Consts;
import com.tiantianchat.heartstone.model.GameCharacter;
import com.tiantianchat.heartstone.model.dto.Minion;
import com.tiantianchat.heartstone.model.dto.Profession;
import org.springframework.stereotype.Component;

import static com.tiantianchat.heartstone.invoker.Com.causeDamage;

/**
 * 法术
 */
@Component
public class Spells {

    @ManaCost(value = 0, desc = "幸运币")
    public void luckyCoin(Profession src) {
        if (src.getCurCrystal() < Consts.MAX_MANA) {
            src.setCrystal(src.getCurCrystal() + 1);
        }
    }

    @ManaCost(value = 4, desc = "火球术")
    public void fireBall(GameCharacter tar) {
        causeDamage(tar, 6);
    }

    @ManaCost(value = 10, desc = "炎爆术")
    public void pyroblast(GameCharacter tar) {
        causeDamage(tar, 10);
    }

    @ManaCost(value = 3, desc = "暗影箭")
    public void shadowArrow(Minion minion) {
        causeDamage(minion, 4);
    }

}
