package com.tiantianchat.heartstone.test;

import com.tiantianchat.heartstone.character.Hero;

import static com.tiantianchat.heartstone.InitGame.getHero;

/**
 * @author Wangyl
 * @date 2019/7/10
 */
public class SpellTest {

    public void testLuckyCoin() {
        Hero shaman = getHero("Shaman");
        shaman.castSpell("luckyCoin");
        assert shaman.getCurCrystal() == 1;

        shaman.castSpell("luckyCoin");
        shaman.castSpell("luckyCoin");
        shaman.castSpell("luckyCoin");

        assert shaman.getCurCrystal() == 4;
    }
}
