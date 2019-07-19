package com.tiantianchat.heartstone.skill;

import com.tiantianchat.heartstone.exception.ShamanTotemFullException;
import com.tiantianchat.model.heartstone.GameCharacter;
import com.tiantianchat.model.heartstone.dto.Minion;
import com.tiantianchat.model.heartstone.dto.Profession;
import com.tiantianchat.repository.MinionRepository;
import com.tiantianchat.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Ramble
 */
@Component
class Skill {

    private final MinionRepository mr;

    private final WeaponRepository wr;

    private final CardDrawer cd;

    @Autowired
    public Skill(MinionRepository mr, WeaponRepository wr, CardDrawer cd) {
        this.mr = mr;
        this.wr = wr;
        this.cd = cd;
    }

    @ManaCost(value = 2, desc = "战士技能")
    public void add2Armor(Profession src) {
        src.setArmor(src.getArmor() + 2);
    }

    @ManaCost(value = 2, desc = "德鲁伊技能")
    public void reshape(Profession src) {
        src.setArmor(src.getArmor() + 1);
        src.setAttack(src.getAttack() + 1);
    }

    @ManaCost(value = 2, desc = "圣骑士技能")
    public void geneReporter(Profession src) {
        List<Minion> scene = src.getScene();
        scene.add(mr.findByName("报告兵").toDTO());
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

    @ManaCost(value = 2, desc = "猎人技能")
    public void shoot(GameCharacter tar) {
        if (tar instanceof Profession) {
            Profession target = (Profession) tar;
            target.setCurBlood(target.getCurBlood() - 2);
        } else if (tar instanceof Minion) {
            Minion target = (Minion) tar;
            target.setCurBlood(target.getCurBlood() - 2);
        }
    }

    @ManaCost(value = 2, desc = "牧师技能")
    public void heal(GameCharacter tar) {
        if (tar instanceof Profession) {
            Profession target = (Profession) tar;
            if (target.getCurBlood() + 2 >= target.getBlood()) {
                target.setCurBlood(target.getBlood());
            } else {
                target.setCurBlood(target.getCurBlood() + 2);
            }
        } else if (tar instanceof Minion) {
            Minion target = (Minion) tar;
            if (target.getCurBlood() + 2 >= target.getBlood()) {
                target.setCurBlood(target.getBlood());
            } else {
                target.setCurBlood(target.getCurBlood() + 2);
            }
        }
    }

    @ManaCost(value = 2, desc = "潜行者技能")
    public void equipDagger(Profession src) {
        src.setWeapon(wr.findByName("匕首").toDTO());
    }

    @ManaCost(value = 2, desc = "术士技能")
    public void drawCard(Profession src) {
        src.setCurBlood(src.getCurBlood() - 2);
        cd.draw(src, 1);
    }

    @ManaCost(value = 2, desc = "萨满技能")
    public void geneTotem(Profession src) throws ShamanTotemFullException {

        List<Minion> scene = src.getScene();

        List<Minion> basicTotems = Arrays.asList(
                mr.findByName("灼热图腾").toDTO(),
                mr.findByName("法强图腾").toDTO(),
                mr.findByName("治疗图腾").toDTO(),
                mr.findByName("嘲讽图腾").toDTO()
        );

        List<Minion> availableTotems = new ArrayList<>();

        basicTotems.forEach(t -> {
            if (!scene.contains(t)) {
                availableTotems.add(t);
            }
        });

        if (availableTotems.size() == 0) {
            throw new ShamanTotemFullException();
        }

        int randomIndex = new Random().nextInt(availableTotems.size());

        scene.add(availableTotems.get(randomIndex));
        src.setScene(scene);
    }
}
