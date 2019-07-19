package com.tiantianchat.heartstone.skill;

import com.tiantianchat.model.heartstone.GameCharacter;
import com.tiantianchat.model.heartstone.dto.Minion;
import com.tiantianchat.model.heartstone.dto.Profession;

/**
 * @author Wangyl
 * @date 2019/7/10
 */
public class Spell {

    @ManaCost(value = 0, desc = "幸运币")
    public void luckyCoin(Profession src) {
        src.setCrystal(src.getCurCrystal() + 1);
    }

    @ManaCost(value = 4, desc = "火球术")
    public void fileBall(Profession src, GameCharacter tar) {

    }

    @ManaCost(value = 10, desc = "炎爆")
    public void pyroblast(Profession src, GameCharacter tar) {
    }

    @ManaCost(value = 3, desc = "暗影箭")
    public void shadowArrow(Profession src, Minion minion) {
    }
}
