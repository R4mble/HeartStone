package com.tiantianchat.heartstone.test;

import com.tiantianchat.heartstone.Main;
import com.tiantianchat.heartstone.character.Hero;
import static com.tiantianchat.heartstone.Main.getHero;
import static com.tiantianchat.heartstone.Main.getMinion;

import com.tiantianchat.heartstone.character.Minion;
import com.tiantianchat.heartstone.exception.ManaLessException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        assert mage.getCrystal() == 1;
        assert war.getHealth() == 29;
    }

    public void testAdd2Armor() {
        Hero war = getHero("战士");

        war.setCrystal(6);
        war.invokeSkill();
        war.invokeSkill();
        war.invokeSkill();

        assert war.getHealth() == 36;
        assert war.getArmor() == 6;
        assert war.getBlood() == 30;
        assert war.getCurBlood() == 30;
        assert war.getCrystal() == 0;
    }

    public void testGeneReporter() {
        Hero paladin = getHero("Paladin");

        paladin.setCrystal(8);

        paladin.invokeSkill();
        paladin.invokeSkill();
        paladin.invokeSkill();
        paladin.invokeSkill();

        assert paladin.getCrystal() == 0;

        Minion reporter = getMinion("Reporter");
        assert paladin.getScene().getMinions()
                    .equals(Arrays.asList(reporter, reporter, reporter, reporter));
    }

    public void testGeneTotem() {
        Hero paladin = getHero("萨满");

        paladin.setCrystal(8);

        paladin.invokeSkill();
        paladin.invokeSkill();
        paladin.invokeSkill();
        paladin.invokeSkill();

        assert paladin.getCrystal() == 0;

        assert paladin.getScene().size() == 4;
    }

    public void testHeal() {
        Hero mushi = getHero("牧师");
        mushi.setCrystal(6);

        Minion reporter = getMinion("Reporter");
        Hero paladin = getHero("Paladin");

        paladin.setCurBlood(29);
        mushi.invokeSkill(paladin);
        assert paladin.getCurBlood() == 30;

        paladin.setCurBlood(23);
        mushi.invokeSkill(paladin);
        assert paladin.getCurBlood() == 25;

        mushi.invokeSkill(reporter);
        assert reporter.getCurBlood() == 1;
    }

    public void testShoot() {
        Hero hunter = getHero("Hunter");
        Hero war = getHero("战士");

        war.setCrystal(3);
        war.invokeSkill();

        hunter.setCrystal(7);
        hunter.invokeSkill(war);
        hunter.invokeSkill(war);
        hunter.invokeSkill(war);

        assert war.getHealth() == 26;
        assert hunter.getCrystal() == 1;
    }



}
