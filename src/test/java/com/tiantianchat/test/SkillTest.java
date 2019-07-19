package com.tiantianchat.test;

import com.tiantianchat.heartstone.skill.SkillInvoker;
import com.tiantianchat.model.heartstone.entity.ProfessionEntity;
import com.tiantianchat.repository.ProfessionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author Wangyl
 * @date 2019/7/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SkillTest {

    @Autowired
    private ProfessionRepository pr;

//    @Test
//    public void testFire() {
//
//        ProfessionEntity mage = pr.findByName("法师");
//        ProfessionEntity war = pr.findByName("战士");
//
//        mage.setCrystal(3);
//
//        mage.invokeSkill(war);
//
//        try {
//            mage.invokeSkill(war);
//        } catch (Exception e) {
//            assert e instanceof ManaLessException;
//        }
//
//        assert mage.curCrystal == 1;
//        assert war.getHealth() == 29;
//    }
//
    @Test
    public void testAdd2Armor() {
        ProfessionEntity war = pr.findByName("战士");

        war.setCrystal(6);
        SkillInvoker.invokeSkill(war);

        assert war.getHealth() == 36;
        assert war.getArmor() == 6;
        assert war.getBlood() == 30;
        assert war.getCurBlood() == 30;
        assert war.getCurCrystal() == 0;
    }
//
//    @Test
//    public void testGeneReporter() {
//        ProfessionEntity paladin = pr.findByName("Paladin");
//
//        paladin.setCrystal(8);
//
//        paladin.invokeSkill();
//        paladin.invokeSkill();
//        paladin.invokeSkill();
//        paladin.invokeSkill();
//
//        assert paladin.curCrystal == 0;
//
//        Minion reporter = getMinion("报告兵");
//        assert paladin.scene.getMinions()
//                    .equals(Arrays.asList(reporter, reporter, reporter, reporter));
//    }
//
//    @Test
//    public void testGeneTotem() {
//        ProfessionEntity shaman = pr.findByName("萨满");
//
//        shaman.setCrystal(8);
//
//        shaman.invokeSkill();
//        shaman.invokeSkill();
//        shaman.invokeSkill();
//        shaman.invokeSkill();
//
//        assert shaman.curCrystal == 0;
//
//        assert shaman.scene.size() == 4;
//    }
//
//    @Test
//    public void testHeal() {
//        ProfessionEntity mushi = pr.findByName("牧师");
//        mushi.setCrystal(6);
//
//        Minion reporter = getMinion("报告兵");
//        ProfessionEntity paladin = pr.findByName("Paladin");
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
//        ProfessionEntity hunter = pr.findByName("Hunter");
//        ProfessionEntity war = pr.findByName("战士");
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
//        ProfessionEntity shushi = pr.findByName("术士");
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
//        ProfessionEntity zie = pr.findByName("潜行者");
//        zie.setCrystal(3);
//        zie.invokeSkill();
//        assert zie.weapon.equals(getWeapon("匕首"));
//    }
}
