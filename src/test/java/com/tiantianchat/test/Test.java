package com.tiantianchat.test;

import java.lang.reflect.Method;


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
