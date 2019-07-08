package com.tiantianchat.heartstone;


import com.tiantianchat.heartstone.model.Hero;
import com.tiantianchat.heartstone.model.Paladin;
import com.tiantianchat.heartstone.model.Warrior;
import com.tiantianchat.heartstone.skill.Skill;

/**
 * @author Ramble
 */
public class Main {

    public static void main(String[] args) {
        Hero paladin = new Paladin();
        Skill.geneReporter(paladin);
        Skill.geneReporter(paladin);

        System.out.println(paladin.getScene());

        Hero warrior = new Warrior();
        Skill.add2Armor(warrior);
        Skill.add2Armor(warrior);
        Skill.add2Armor(warrior);

        System.out.println(warrior.getHealth());

    }
}
