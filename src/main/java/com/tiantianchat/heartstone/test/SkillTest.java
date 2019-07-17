package com.tiantianchat.heartstone.test;

import com.tiantianchat.heartstone.character.Hero;

import com.tiantianchat.heartstone.character.Minion;
import com.tiantianchat.heartstone.exception.ManaLessException;
import com.tiantianchat.heartstone.model.Card;
import com.tiantianchat.heartstone.model.CardLibrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.tiantianchat.heartstone.InitGame.*;

/**
 * @author Wangyl
 * @date 2019/7/10
 */
public class SkillTest {

    public void testFire() {
        Hero mage = getHero("法师");
        Hero war = getHero("战士");

        mage.setCrystal(3);
        mage.invokeSkill(war);

        try {
            mage.invokeSkill(war);
        } catch (Exception e) {
            assert e instanceof ManaLessException;
        }

        assert mage.curCrystal == 1;
        assert war.getHealth() == 29;
    }

//    public void testAdd2Armor() {
//        Hero war = getHero("战士");
//
//        war.setCrystal(6);
//        war.invokeSkill();
//        war.invokeSkill();
//        war.invokeSkill();
//
//        assert war.getHealth() == 36;
//        assert war.armor == 6;
//        assert war.blood == 30;
//        assert war.curBlood == 30;
//        assert war.curCrystal == 0;
//    }
//
//    public void testGeneReporter() {
//        Hero paladin = getHero("Paladin");
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
//        Minion reporter = getMinion("Reporter");
//        assert paladin.scene.getMinions()
//                    .equals(Arrays.asList(reporter, reporter, reporter, reporter));
//    }
//
//    public void testGeneTotem() {
//        Hero shaman = getHero("萨满");
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
//    public void testHeal() {
//        Hero mushi = getHero("牧师");
//        mushi.setCrystal(6);
//
//        Minion reporter = getMinion("Reporter");
//        Hero paladin = getHero("Paladin");
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
//    public void testShoot() {
//        Hero hunter = getHero("Hunter");
//        Hero war = getHero("战士");
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
//    public void testDrawCard() {
//        Hero shushi = getHero("术士");
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
//    public void testEquipDagger() {
//        Hero zie = getHero("潜行者");
//        zie.setCrystal(3);
//        zie.invokeSkill();
//        assert zie.weapon.equals(getWeapon("匕首"));
//    }
}
