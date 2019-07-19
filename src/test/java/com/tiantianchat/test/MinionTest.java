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
import java.util.List;



/**
 * @author Wangyl
 * @date 2019/7/11
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MinionTest {

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
    public void basic() {
        Profession shaman = pr.findByName("萨满").toDTO();
        Profession fashi = pr.findByName("法师").toDTO();

        List<Card> cards = new ArrayList<>();
        List<Card> cards2 = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            cards.add(mr.findByName("淡水鳄").toDTO());
            cards2.add(mr.findByName("淡水鳄").toDTO());
        }

        shaman.setCardLibrary(cards);
        fashi.setCardLibrary(cards2);

        cardDrawer.draw(shaman, 4);
        assert shaman.getCardLibrary().size() == 26;

        cardDrawer.draw(fashi, 4);
        assert fashi.getCardLibrary().size() == 26;
    }

    @Test
    public void testElfArcher() {
        Profession shaman = pr.findByName("萨满").toDTO();
        Profession fashi = pr.findByName("法师").toDTO();

        Minion m = mr.findByName("精灵弓箭手").toDTO();

        shaman.getHandCard().add(m);

        shaman.setCrystal(4);
        mc.sendMinion(shaman, m, fashi);

        assert fashi.getCurBlood() == 29;
    }

    public void attack() {

    }
}
