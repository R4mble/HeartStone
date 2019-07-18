package com.tiantianchat.test;

import com.tiantianchat.heartstone.character.Hero;
import com.tiantianchat.heartstone.character.Minion;
import com.tiantianchat.heartstone.model.Card;
import com.tiantianchat.heartstone.model.CardLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.tiantianchat.heartstone.InitGame.getHero;
import static com.tiantianchat.heartstone.InitGame.getMinion;

/**
 * @author Wangyl
 * @date 2019/7/11
 */
public class BattleTest {

    public void battleBegin() {
        Hero fashi = getHero("法师");
        Hero shengqishi = getHero("圣骑士");

        List<Card> cards = Arrays.asList(getMinion("淡水鳄"),
                getMinion("迅猛龙"),getMinion("精灵弓箭手"),
                getMinion("巫医"),getMinion("闪金镇步兵"),
                getMinion("工程师学徒"),getMinion("酸性沼泽软泥怪"),
                getMinion("团队领袖"),getMinion("破碎残阳祭祀"),
                getMinion("暴风城骑士"),getMinion("机械幼龙技工"),
                getMinion("食人魔法师"),getMinion("古拉巴什狂暴者"),
                getMinion("暗鳞治愈者"),getMinion("霜狼督军"));

        List<Card> cardList = new ArrayList<>();
        for (Card c : cards) {
            cardList.add(c);
            cardList.add(getMinion(((Minion) c).name));
        }

        List<Card> cards2 = new ArrayList<>(cardList);

        fashi.cardLibrary = (new CardLibrary(cardList));
        shengqishi.cardLibrary = (new CardLibrary(cards2));

        fashi.drawCard(4);
        shengqishi.drawCard(4);

        assert fashi.handCard.size() == 4;
        assert shengqishi.handCard.size() == 4;
        assert fashi.cardLibrary.size() == 26;
        assert shengqishi.cardLibrary.size() == 26;

    }

}
