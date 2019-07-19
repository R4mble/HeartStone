package com.tiantianchat.heartstone.skill;

import com.tiantianchat.model.heartstone.entity.ProfessionEntity;

/**
 * @author Ramble
 */
public class Skill {
    
    @ManaCost(value = 2, desc = "战士技能")
    public void add2Armor(ProfessionEntity src) {
        src.setArmor(src.getArmor() + 2);
    }

//    @ManaCost(value = 2, desc = "德鲁伊技能")
//    public void reshape(ProfessionEntity src) {
//        src.armor++;
//        src.attack++;
//    }
//
//    @ManaCost(value = 2, desc = "圣骑士技能")
//    public void geneReporter(ProfessionEntity src) {
//        Scene scene = src.scene;
//        scene.addLast(InitGame.getMinion("报告兵"));
//        src.scene = (scene);
//    }
//
//    @ManaCost(value = 2, desc = "法师技能")
//    public void fire(ProfessionEntity src, Character character) {
//        character.curBlood = (character.curBlood - 1);
//    }
//
//    @ManaCost(value = 2, desc = "猎人技能")
//    public void shoot(ProfessionEntity src, Character character) {
//        character.curBlood = (character.curBlood - 2);
//    }
//
//    @ManaCost(value = 2, desc = "牧师技能")
//    public void heal(ProfessionEntity src, Character character) {
//        if (character.curBlood + 2 >= character.blood) {
//            character.curBlood = (character.blood);
//        } else {
//            character.curBlood = (character.curBlood + 2);
//        }
//    }
//
//    @ManaCost(value = 2, desc = "潜行者技能")
//    public void equipDagger(ProfessionEntity src) {
//        src.weapon = (InitGame.getWeapon("匕首"));
//    }
//
//    @ManaCost(value = 2, desc = "术士技能")
//    public void drawCard(ProfessionEntity src) {
//        src.curBlood = (src.curBlood - 2);
//        src.drawCard(1);
//    }
//
//    @ManaCost(value = 2, desc = "萨满技能")
//    public void geneTotem(ProfessionEntity src) {
//        Scene scene = src.scene;
//
//        List<Minion> basicTotems = Arrays.asList(
//                InitGame.getMinion("灼热图腾"),
//                InitGame.getMinion("法强图腾"),
//                InitGame.getMinion("治疗图腾"),
//                InitGame.getMinion("嘲讽图腾")
//        );
//
//        List<Minion> availableTotems = new ArrayList<>();
//        basicTotems.forEach(t -> {
//            if (!scene.exist(t.name)) {
//                availableTotems.add(t);
//            }
//        });
//
//        if (availableTotems.size() == 0) {
//            throw new ShamanTotemFullException();
//        }
//
//        int randomIndex = new Random().nextInt(availableTotems.size());
//
//        scene.addLast(availableTotems.get(randomIndex));
//        src.scene = (scene);
//    }
}
