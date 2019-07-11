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

    public static void main(String[] args) {

        new InitGame();

        invokeTests(new SkillTest(), new SpellTest(), new MinionTest(), new BattleTest());
    }

    private static void invokeTests(Object... objects) {
        try {
            for (Object o : objects) {
                Method[] methods = o.getClass().getDeclaredMethods();
                for (Method m : methods) {
                    m.invoke(o);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
