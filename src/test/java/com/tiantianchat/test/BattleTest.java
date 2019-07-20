package com.tiantianchat.test;

import com.tiantianchat.heartstone.invoker.CardDrawer;
import com.tiantianchat.heartstone.invoker.CardExecutor;
import com.tiantianchat.heartstone.invoker.MinionCommander;
import com.tiantianchat.heartstone.invoker.SkillInvoker;
import com.tiantianchat.heartstone.model.Card;
import com.tiantianchat.heartstone.model.dto.Profession;
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
 *
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BattleTest {


    @Autowired
    private SkillInvoker si;

    @Autowired
    private ProfessionRepository pr;

    @Autowired
    private MinionRepository mr;

    @Autowired
    private WeaponRepository wr;

    @Autowired
    private CardDrawer cd;

    @Autowired
    private CardExecutor ce;

    @Autowired
    private MinionCommander mc;

    @Test
    public void battleBegin() {
        Profession fashi = pr.findByName("法师").toDTO();
        Profession shengqishi = pr.findByName("圣骑士").toDTO();

        List<Card> cards = Arrays.asList(mr.findByName("淡水鳄").toDTO(),
                mr.findByName("迅猛龙").toDTO(),mr.findByName("精灵弓箭手").toDTO(),
                mr.findByName("巫医").toDTO(),mr.findByName("闪金镇步兵").toDTO(),
                mr.findByName("工程师学徒").toDTO(),mr.findByName("酸性沼泽软泥怪").toDTO(),
                mr.findByName("团队领袖").toDTO(),mr.findByName("破碎残阳祭祀").toDTO(),
                mr.findByName("暴风城骑士").toDTO(),mr.findByName("机械幼龙技工").toDTO(),
                mr.findByName("食人魔法师").toDTO(),mr.findByName("古拉巴什狂暴者").toDTO(),
                mr.findByName("暗鳞治愈者").toDTO(),mr.findByName("霜狼督军").toDTO());

        List<Card> cardList = new ArrayList<>();

        for (Card c : cards) {
            cardList.add(c);
            cardList.add(c);
        }

        List<Card> cards2 = new ArrayList<>(cardList);

        fashi.setCardLibrary(cardList);
        shengqishi.setCardLibrary(cards2);

        cd.draw(fashi, 4);
        cd.draw(shengqishi, 4);

        assert fashi.getHandCard().size() == 4;
        assert shengqishi.getHandCard().size() == 4;
        assert fashi.getCardLibrary().size() == 26;
        assert shengqishi.getCardLibrary().size() == 26;
    }

    @Test
    public void battle0() {
        Profession fashi = pr.findByName("法师").toDTO();
        Profession shengqishi = pr.findByName("圣骑士").toDTO();

        fashi.getHandCard().add(mr.findByName("巫医").toDTO());

        shengqishi.setCurBlood(23);
        fashi.setCrystal(3);

        ce.exec(fashi, mr.findByName("巫医").toDTO(), shengqishi);

        assert shengqishi.getCurBlood() == 25;
    }

}
