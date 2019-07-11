package com.tiantianchat.heartstone.test;

import com.tiantianchat.heartstone.character.Hero;
import com.tiantianchat.heartstone.model.Card;
import com.tiantianchat.heartstone.model.CardLibrary;

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

        shaman.setCardLibrary(new CardLibrary(cards));
        fashi.setCardLibrary(new CardLibrary(cards2));

        shaman.drawCard(4);
        assert shaman.getCardLibrary().size() == 26;

        fashi.drawCard(4);
        assert fashi.getCardLibrary().size() == 26;

        fashi.useMinion(fashi.getHandCard().getMinion(0));
        assert fashi.getHandCard().size() == 3;
        assert fashi.getScene().size() == 1;
    }

    public void attack() {

    }
}
