package com.tiantianchat.heartstone.skill;

import com.tiantianchat.model.heartstone.GameCharacter;
import com.tiantianchat.model.heartstone.dto.Minion;
import com.tiantianchat.model.heartstone.dto.Profession;
import org.springframework.stereotype.Component;

import static com.tiantianchat.heartstone.skill.Attack.causeDamage;

/**
 * @author Wangyl
 * @date 2019/7/10
 */
@Component
public class Spell {

    @ManaCost(value = 0, desc = "幸运币")
    public void luckyCoin(Profession src) {
        src.setCrystal(src.getCurCrystal() + 1);
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
