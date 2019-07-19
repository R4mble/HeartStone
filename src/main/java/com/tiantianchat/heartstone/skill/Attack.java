package com.tiantianchat.heartstone.skill;

import com.tiantianchat.model.heartstone.GameCharacter;
import com.tiantianchat.model.heartstone.dto.Minion;
import com.tiantianchat.model.heartstone.dto.Profession;

/**
 * @author Ramble
 */
public class Attack {

    public static void causeDamage(GameCharacter tar, int damage) {
        if (tar instanceof Profession) {
            Profession target = (Profession)tar;
            target.setCurBlood(target.getCurBlood() - damage);
        } else if (tar instanceof Minion) {
            Minion target = (Minion)tar;
            target.setCurBlood(target.getCurBlood() - damage);
        }
    }
}
