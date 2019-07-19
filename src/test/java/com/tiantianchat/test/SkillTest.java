package com.tiantianchat.test;

import com.tiantianchat.heartstone.exception.ManaLessException;
import com.tiantianchat.heartstone.exception.ShamanTotemFullException;
import com.tiantianchat.heartstone.skill.SkillInvoker;
import com.tiantianchat.model.heartstone.dto.Minion;
import com.tiantianchat.model.heartstone.dto.Profession;
import com.tiantianchat.repository.MinionRepository;
import com.tiantianchat.repository.ProfessionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;


/**
 * @author Wangyl
 * @date 2019/7/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SkillTest {

    @Autowired
    private SkillInvoker skillInvoker;

    @Autowired
    private ProfessionRepository pr;

    @Autowired
    private MinionRepository mr;

    @Test
    public void testAdd2Armor() {
        Profession war = pr.findByName("战士").toDTO();

        war.setCrystal(6);
        skillInvoker.invoke(war);
        skillInvoker.invoke(war);
        skillInvoker.invoke(war);

        assert war.getHealth() == 36;
        assert war.getArmor() == 6;
        assert war.getBlood() == 30;
        assert war.getCurBlood() == 30;
        assert war.getCurCrystal() == 0;
    }
    
    @Test
    public void testFire() {

        Profession mage = pr.findByName("法师").toDTO();
        Profession war = pr.findByName("战士").toDTO();

        mage.setCrystal(3);

        skillInvoker.invoke(mage, war);

        try {
            skillInvoker.invoke(mage, war);
        } catch (Exception e) {
            assert e instanceof ManaLessException;
        }

        assert mage.getCurCrystal() == 1;
        assert war.getHealth() == 29;
    }

    @Test
    public void testGeneReporter() {
        Profession paladin = pr.findByName("圣骑士").toDTO();

        paladin.setCrystal(8);

        skillInvoker.invoke(paladin);
        skillInvoker.invoke(paladin);
        skillInvoker.invoke(paladin);
        skillInvoker.invoke(paladin);

        assert paladin.getCurCrystal() == 0;

        Minion reporter = mr.findByName("报告兵").toDTO();
        assert paladin.getScene()
                    .equals(Arrays.asList(reporter, reporter, reporter, reporter));
    }

    @Test
    public void testGeneTotem() {
        Profession shaman = pr.findByName("萨满").toDTO();

        shaman.setCrystal(10);

        skillInvoker.invoke(shaman);
        skillInvoker.invoke(shaman);
        skillInvoker.invoke(shaman);
        skillInvoker.invoke(shaman);

        try {
            skillInvoker.invoke(shaman);
        } catch (Exception e) {
            assert e instanceof ShamanTotemFullException;
        }

        assert shaman.getCurCrystal() == 2;
        assert shaman.getScene().size() == 4;
    }

    @Test
    public void testHeal() {
        Profession mushi = pr.findByName("牧师").toDTO();
        mushi.setCrystal(8);

        Minion reporter = mr.findByName("报告兵").toDTO();
        Profession paladin = pr.findByName("圣骑士").toDTO();

        paladin.setCurBlood(29);
        skillInvoker.invoke(mushi, paladin);
        skillInvoker.invoke(mushi, paladin);
        assert paladin.getCurBlood() == 30;

        paladin.setCurBlood(23);
        skillInvoker.invoke(mushi, paladin);
        assert paladin.getCurBlood() == 25;

        skillInvoker.invoke(mushi, reporter);
        assert reporter.getCurBlood() == 1;
    }

    @Test
    public void testShoot() {
        Profession hunter = pr.findByName("猎人").toDTO();
        Profession war = pr.findByName("战士").toDTO();

        war.setCrystal(3);
        skillInvoker.invoke(war);

        hunter.setCrystal(7);
        skillInvoker.invoke(hunter, war);
        skillInvoker.invoke(hunter, war);
        skillInvoker.invoke(hunter, war);

        assert war.getHealth() == 26;
        assert hunter.getCurCrystal() == 1;
    }

//    @Test
//    public void testDrawCard() {
//        Profession shushi = pr.findByName("术士");
//
//        List<Card> cards = new ArrayList<>();
//
//        for (int i = 0; i < 30; i++) {
//            cards.add(getMinion("淡水鳄"));
//        }
//
//        shushi.curCrystal = (3);
//        shushi.cardLibrary = (new CardLibrary(cards));
//
//        shushi.invokeSkill();
//
//        assert shushi.curCrystal == 1;
//        assert shushi.curBlood == 28;
//        assert shushi.handCard.size() == 1;
//        assert shushi.cardLibrary.size() == 29;
//    }
//
//    @Test
//    public void testEquipDagger() {
//        Profession zie = pr.findByName("潜行者");
//        zie.setCrystal(3);
//        zie.invokeSkill();
//        assert zie.weapon.equals(getWeapon("匕首"));
//    }
}
