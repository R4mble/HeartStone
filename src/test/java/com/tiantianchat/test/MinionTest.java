package com.tiantianchat.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.tiantianchat.heartstone.InitGame.getHero;
import static com.tiantianchat.heartstone.InitGame.getMinion;

/**
 * @author Wangyl
 * @date 2019/7/11
 */
public class MinionTest {

    public void basic() {
        Hero shaman = getHero("Shaman");
        Hero fashi = getHero("Mage");

        List<Card> cards = new ArrayList<>();
        List<Card> cards2 = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            cards.add(getMinion("淡水鳄"));
            cards2.add(getMinion("淡水鳄"));
        }

        shaman.cardLibrary = (new CardLibrary(cards));
        fashi.cardLibrary = (new CardLibrary(cards2));

        shaman.drawCard(4);
        assert shaman.cardLibrary.size() == 26;

        fashi.drawCard(4);
        assert fashi.cardLibrary.size() == 26;

        fashi.useMinion(fashi.handCard.getMinion(0));
        assert fashi.handCard.size() == 3;
        assert fashi.scene.size() == 1;
    }

    @Test
    public void useMinion() {
        Hero shaman = getHero("Shaman");
        Minion m = getMinion("精灵弓箭手");
        shaman.handCard.addLast(m);

        shaman.useMinion(m);

    }

    public void attack() {

    }
}
