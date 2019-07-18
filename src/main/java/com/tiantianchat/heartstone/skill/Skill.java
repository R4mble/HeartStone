package com.tiantianchat.heartstone.skill;

import com.tiantianchat.heartstone.InitGame;
import com.tiantianchat.heartstone.character.Hero;
import com.tiantianchat.heartstone.character.Minion;
import com.tiantianchat.heartstone.exception.ShamanTotemFullException;
import com.tiantianchat.heartstone.model.Scene;
import com.tiantianchat.heartstone.character.Character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Ramble
 */
public class Skill {

    @ManaCost(value = 2, desc = "战士技能")
    public void add2Armor(Hero hero) {
        hero.armor = (hero.armor + 2);
    }

    @ManaCost(value = 2, desc = "德鲁伊技能")
    public void reshape(Hero hero) {
        hero.armor++;
        hero.attack++;
    }

    @ManaCost(value = 2, desc = "圣骑士技能")
    public void geneReporter(Hero hero) {
        Scene scene = hero.scene;
        scene.addLast(InitGame.getMinion("报告兵"));
        hero.scene = (scene);
    }

    @ManaCost(value = 2, desc = "法师技能")
    public void fire(Hero hero, Character character) {
        character.curBlood = (character.curBlood - 1);
    }

    @ManaCost(value = 2, desc = "猎人技能")
    public void shoot(Hero hero, Character character) {
        character.curBlood = (character.curBlood - 2);
    }

    @ManaCost(value = 2, desc = "牧师技能")
    public void heal(Hero hero, Character character) {
        if (character.curBlood + 2 >= character.blood) {
            character.curBlood = (character.blood);
        } else {
            character.curBlood = (character.curBlood + 2);
        }
    }

    @ManaCost(value = 2, desc = "潜行者技能")
    public void equipDagger(Hero hero) {
        hero.weapon = (InitGame.getWeapon("匕首"));
    }

    @ManaCost(value = 2, desc = "术士技能")
    public void drawCard(Hero hero) {
        hero.curBlood = (hero.curBlood - 2);
        hero.drawCard(1);
    }

    @ManaCost(value = 2, desc = "萨满技能")
    public void geneTotem(Hero hero) {
        Scene scene = hero.scene;

        List<Minion> basicTotems = Arrays.asList(
                InitGame.getMinion("灼热图腾"),
                InitGame.getMinion("法强图腾"),
                InitGame.getMinion("治疗图腾"),
                InitGame.getMinion("嘲讽图腾")
        );

        List<Minion> availableTotems = new ArrayList<>();
        basicTotems.forEach(t -> {
            if (!scene.exist(t.name)) {
                availableTotems.add(t);
            }
        });

        if (availableTotems.size() == 0) {
            throw new ShamanTotemFullException();
        }

        int randomIndex = new Random().nextInt(availableTotems.size());

        scene.addLast(availableTotems.get(randomIndex));
        hero.scene = (scene);
    }
}
