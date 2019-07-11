package com.tiantianchat.heartstone.test;

import com.tiantianchat.heartstone.InitGame;
import com.tiantianchat.heartstone.character.Hero;
import com.tiantianchat.heartstone.model.Card;
import com.tiantianchat.heartstone.model.CardLibrary;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.tiantianchat.heartstone.InitGame.getHero;
import static com.tiantianchat.heartstone.InitGame.getMinion;

/**
 * @author Wangyl
 * @date 2019/7/10
 */
public class Test {

    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {
//        new InitGame();
//
//        Hero shaman = getHero("Shaman");
//        Hero fashi = getHero("Mage");
//
//        List<Card> cards = new ArrayList<>();
//        List<Card> cards2 = new ArrayList<>();
//
//        for (int i = 0; i < 30; i++) {
//            cards.add(getMinion("淡水鳄"));
//            cards2.add(getMinion("淡水鳄"));
//        }
//
//        shaman.setCardLibrary(new CardLibrary(cards));
//        fashi.setCardLibrary(new CardLibrary(cards2));
//
//        shaman.drawCard(4);
//        System.out.println(shaman.getHandCard());
//        System.out.println(shaman.getCardLibrary().size());
//
//        fashi.drawCard(4);
//        System.out.println(fashi.getHandCard());
//        System.out.println(fashi.getCardLibrary().size());
//
//        fashi.useMinion(fashi.getHandCard().getMinion(0));
//        System.out.println(fashi.getHandCard());
//        System.out.println(fashi.getScene());
//
//        fashi.castSpell("luckyCoin");
//        System.out.println(fashi.getCurCrystal());

        invokeTests();
    }

    private static void invokeTests() throws IOException, InvocationTargetException, IllegalAccessException {
        new InitGame();

        SkillTest skillTest = new SkillTest();
        SpellTest spellTest = new SpellTest();

        Method[] methods = SkillTest.class.getDeclaredMethods();
        Method[] methods2 = SpellTest.class.getDeclaredMethods();

        for (Method m : methods) {
            m.invoke(skillTest);
        }

        for (Method m : methods2) {
            m.invoke(spellTest);
        }

    }

}
