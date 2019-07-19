package com.tiantianchat.test;

import com.tiantianchat.heartstone.exception.ManaLessException;
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

        shaman.setCrystal(100);

        skillInvoker.invoke(shaman);
        skillInvoker.invoke(shaman);
        skillInvoker.invoke(shaman);
        skillInvoker.invoke(shaman);
        skillInvoker.invoke(shaman);

        assert shaman.getCurCrystal() == 0;

        assert shaman.getScene().size() == 4;
    }

//    @Test
//    public void testHeal() {
//        Profession mushi = pr.findByName("牧师");
//        mushi.setCrystal(6);
//
//        Minion reporter = getMinion("报告兵");
//        Profession paladin = pr.findByName("Paladin");
//
//        paladin.curBlood = (29);
//        mushi.invokeSkill(paladin);
//        assert paladin.curBlood == 30;
//
//        paladin.curBlood = (23);
//        mushi.invokeSkill(paladin);
//        assert paladin.curBlood == 25;
//
//        mushi.invokeSkill(reporter);
//        assert reporter.curBlood == 1;
//    }
//
//    @Test
//    public void testShoot() {
//        Profession hunter = pr.findByName("Hunter");
//        Profession war = pr.findByName("战士");
//
//        war.setCrystal(3);
//        war.invokeSkill();
//
//        hunter.setCrystal(7);
//        hunter.invokeSkill(war);
//        hunter.invokeSkill(war);
//        hunter.invokeSkill(war);
//
//        assert war.getHealth() == 26;
//        assert hunter.curCrystal == 1;
//    }
//
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
