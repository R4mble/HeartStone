package com.tiantianchat.heartstone.skill;

import com.tiantianchat.heartstone.Main;
import com.tiantianchat.heartstone.character.Hero;
import com.tiantianchat.heartstone.model.Scene;
import com.tiantianchat.heartstone.character.Character;

/**
 * @author Ramble
 */
public class Skill {

    @ManaCost(2)
    public void add2Armor(Hero hero) {
        hero.setArmor(hero.getArmor() + 2);
    }

    @ManaCost(2)
    public void geneReporter(Hero hero) {
        Scene scene = hero.getScene();
        scene.addLast(Main.getMinion("Reporter"));
        hero.setScene(scene);
    }

    @ManaCost(2)
    public void fire(Hero hero, Character character) {
        character.setCurBlood(character.getCurBlood() - 1);
    }

    @ManaCost(2)
    public void shoot(Hero hero, Character character) {
        character.setCurBlood(character.getCurBlood() - 2);
    }

    @ManaCost(2)
    public void heal(Hero hero, Character character) {
        if (character.getCurBlood() + 2 >= character.getBlood()) {
            character.setCurBlood(character.getBlood());
        } else {
            character.setCurBlood(character.getCurBlood() + 2);
        }
    }

    @ManaCost(2)
    public void geneTotem(Hero hero) {
        Scene scene = hero.getScene();
        scene.addLast(Main.getMinion("Reporter"));
        hero.setScene(scene);
    }
}
