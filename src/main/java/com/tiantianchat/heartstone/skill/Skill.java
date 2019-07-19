package com.tiantianchat.heartstone.skill;

import com.tiantianchat.heartstone.character.Hero;
import com.tiantianchat.model.heartstone.Card;
import com.tiantianchat.model.heartstone.GameCharacter;
import com.tiantianchat.model.heartstone.dto.Minion;
import com.tiantianchat.model.heartstone.dto.Profession;
import com.tiantianchat.model.heartstone.entity.MinionEntity;
import com.tiantianchat.repository.MinionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Ramble
 */
@Component
class Skill {

    @Autowired
    private MinionRepository mr;

    @ManaCost(value = 2, desc = "战士技能")
    public void add2Armor(Profession src) {
        src.setArmor(src.getArmor() + 2);
    }

//    @ManaCost(value = 2, desc = "德鲁伊技能")
//    public void reshape(Profession src) {
//        src.armor++;
//        src.attack++;
//    }
//
    @ManaCost(value = 2, desc = "圣骑士技能")
    public void geneReporter(Profession src) {
        List<Card> scene = src.getScene();

        MinionEntity m = mr.findByName("报告兵");
        scene.add(m.toDTO());
        src.setScene(scene);
    }

    @ManaCost(value = 2, desc = "法师技能")
    public void fire(GameCharacter tar) {
        // 手动模式匹配
        if (tar instanceof Profession) {
            ((Profession) tar).setCurBlood(((Profession) tar).getCurBlood() - 1);
        } else if (tar instanceof Minion){
            ((Minion) tar).setCurBlood(((Minion) tar).getCurBlood() - 1);
        }
    }

//    @ManaCost(value = 2, desc = "猎人技能")
//    public void shoot(Profession src, GameCharacter character) {
//        character.curBlood = (character.curBlood - 2);
//    }
//
//    @ManaCost(value = 2, desc = "牧师技能")
//    public void heal(Profession src, GameCharacter character) {
//        if (character.curBlood + 2 >= character.blood) {
//            character.curBlood = (character.blood);
//        } else {
//            character.curBlood = (character.curBlood + 2);
//        }
//    }
//
//    @ManaCost(value = 2, desc = "潜行者技能")
//    public void equipDagger(Profession src) {
//        src.weapon = (InitGame.getWeapon("匕首"));
//    }
//
//    @ManaCost(value = 2, desc = "术士技能")
//    public void drawCard(Profession src) {
//        src.curBlood = (src.curBlood - 2);
//        src.drawCard(1);
//    }
//
//    @ManaCost(value = 2, desc = "萨满技能")
//    public void geneTotem(Profession src) {
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
