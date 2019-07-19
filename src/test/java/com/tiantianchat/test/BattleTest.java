package com.tiantianchat.test;

import com.tiantianchat.heartstone.skill.CardDrawer;
import com.tiantianchat.heartstone.skill.MinionCommander;
import com.tiantianchat.heartstone.skill.SkillInvoker;
import com.tiantianchat.model.heartstone.Card;
import com.tiantianchat.model.heartstone.dto.Minion;
import com.tiantianchat.model.heartstone.dto.Profession;
import com.tiantianchat.repository.MinionRepository;
import com.tiantianchat.repository.ProfessionRepository;
import com.tiantianchat.repository.WeaponRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Wangyl
 * @date 2019/7/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BattleTest {


    @Autowired
    private SkillInvoker skillInvoker;

    @Autowired
    private ProfessionRepository pr;

    @Autowired
    private MinionRepository mr;

    @Autowired
    private WeaponRepository wr;

    @Autowired
    private CardDrawer cardDrawer;

    @Autowired
    private MinionCommander mc;

    @Test
    public void battleBegin() {
        Profession fashi = pr.findByName("法师").toDTO();
        Profession shengqishi = pr.findByName("圣骑士").toDTO();

        List<Card> cards = Arrays.asList(mr.findByName("淡水鳄"),
                mr.findByName("迅猛龙"),mr.findByName("精灵弓箭手"),
                mr.findByName("巫医"),mr.findByName("闪金镇步兵"),
                mr.findByName("工程师学徒"),mr.findByName("酸性沼泽软泥怪"),
                mr.findByName("团队领袖"),mr.findByName("破碎残阳祭祀"),
                mr.findByName("暴风城骑士"),mr.findByName("机械幼龙技工"),
                mr.findByName("食人魔法师"),mr.findByName("古拉巴什狂暴者"),
                mr.findByName("暗鳞治愈者"),mr.findByName("霜狼督军"));

        List<Card> cardList = new ArrayList<>();

        for (Card c : cards) {
            cardList.add(c);
            cardList.add(c);
        }

        List<Card> cards2 = new ArrayList<>(cardList);

        fashi.setCardLibrary(cardList);
        shengqishi.setCardLibrary(cards2);

        cardDrawer.draw(fashi, 4);
        cardDrawer.draw(shengqishi, 4);

        assert fashi.getHandCard().size() == 4;
        assert shengqishi.getHandCard().size() == 4;
        assert fashi.getCardLibrary().size() == 26;
        assert shengqishi.getCardLibrary().size() == 26;

    }

}
