package com.tiantianchat.heartstone.model;

import com.tiantianchat.heartstone.character.Hero;
import com.tiantianchat.heartstone.character.Minion;
import lombok.Data;

/**
 * @author Wangyl
 * @date 2019/7/10
 */
@Data
public class Battle {

    private static Hero[] hero;

    public static void over(Hero hero) {

    }

    public static void killMinion(Minion src) {
        for (Hero h : hero) {
            h.getScene().remove(src);
        }
    }

    public void begin() {
        hero[0].drawCard(4);
        hero[1].drawCard(4);
    }
}
