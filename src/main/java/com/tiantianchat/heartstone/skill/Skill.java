package com.tiantianchat.heartstone.skill;

import com.tiantianchat.heartstone.minion.Reporter;
import com.tiantianchat.heartstone.model.Hero;
import com.tiantianchat.heartstone.model.Scene;
import com.tiantianchat.heartstone.minion.Character;
/**
 * @author Ramble
 */
public class Skill {

    public static void add2Armor(Hero hero) {
        hero.setArmor(hero.getArmor() + 2);
    }

    public static void geneReporter(Hero hero) {
        Scene scene = hero.getScene();
        scene.addLast(new Reporter());
        hero.setScene(scene);
    }

    public static void fire(Hero hero, Character character) {

    }
}
