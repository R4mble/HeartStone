package com.tiantianchat.heartstone.invoker;

import com.tiantianchat.heartstone.model.GameCharacter;
import com.tiantianchat.heartstone.model.dto.Minion;
import com.tiantianchat.heartstone.model.dto.Profession;

/**
 * 公共函数
 */
public class Com {

    /**
     * 造成伤害的通用函数
     * @param target 目标
     * @param damage 造成伤害数量
     * @return 目标是否死亡
     */
    public static boolean causeDamage(GameCharacter target, int damage) {
        if (target instanceof Profession) {
            Profession t = (Profession)target;
            t.setCurBlood(t.getCurBlood() - damage);
            return t.getCurBlood() < 1;
        } else {
            Minion t = (Minion)target;
            t.setCurBlood(t.getCurBlood() - damage);
            return t.getCurBlood() < 1;
        }
    }

    // 治疗的通用函数
    public static void heal(GameCharacter target, int blood) {
        if (target instanceof Profession) {
            Profession t = (Profession)target;
            if (t.getCurBlood() + blood > t.getBlood()) {
                t.setCurBlood(t.getBlood());
            } else {
                t.setCurBlood(t.getCurBlood() + blood);
            }
        } else if (target instanceof Minion) {
            Minion t = (Minion)target;
            if (t.getCurBlood() + blood > t.getBlood()) {
                t.setCurBlood(t.getBlood());
            } else {
                t.setCurBlood(t.getCurBlood() + blood);
            }
        }
    }
}
