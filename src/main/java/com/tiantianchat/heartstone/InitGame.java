package com.tiantianchat.heartstone;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiantianchat.heartstone.character.Hero;
import com.tiantianchat.heartstone.character.Minion;
import com.tiantianchat.heartstone.model.Weapon;
import org.springframework.beans.BeanUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ramble
 */
public class InitGame {

    private static List<Hero> heroBox = new ArrayList<>();
    private static List<Minion> minionBox = new ArrayList<>();
    private static List<Weapon> weaponBox = new ArrayList<>();
    private static ObjectMapper mapper = new ObjectMapper();

    private static String DIR = "C:\\Users\\Ramble\\Desktop\\tiantianchat";
    private static String SHENZHOUDIR = "C:\\Users\\Ramble\\Desktop\\MyGitHub\\HeartStone";
    private static String PATH = "\\src\\main\\resources\\";
    public InitGame() {

        DIR = SHENZHOUDIR;

        File heroJsonFile = new File(DIR + PATH + "hero.json");
        List heroList = new ArrayList();
        try {
            heroList = mapper.readValue(heroJsonFile, List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Object o : heroList) {
            Hero h = new Hero();
            Map o1 = (Map) o;
            h.name = (o1.get("name").toString());
            h.skill = (o1.get("skill").toString());
            h.chineseName = (o1.get("chineseName").toString());
            heroBox.add(h);
        }


        File minionJsonFile = new File(DIR + PATH + "minion.json");
        List minionList = new ArrayList();
        try {
            minionList = mapper.readValue(minionJsonFile, List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Object o : minionList) {
            Minion m = new Minion();
            Map o1 = (Map) o;
            m.name = (o1.get("name").toString());
            m.chineseName = (o1.get("chineseName").toString());
            m.attack = (Integer.parseInt(o1.get("attack").toString()));
            m.blood = (Integer.parseInt(o1.get("blood").toString()));
            minionBox.add(m);
        }

        File weaponJsonFile = new File(DIR + PATH + "weapon.json");
        List weaponList = new ArrayList();
        try {
            weaponList = mapper.readValue(weaponJsonFile, List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Object o : weaponList) {
            Weapon m = new Weapon();
            Map o1 = (Map) o;
            m.name = (o1.get("name").toString());
            m.attack = (Integer.parseInt(o1.get("attack").toString()));
            m.durability = (Integer.parseInt(o1.get("durability").toString()));
            weaponBox.add(m);
        }

    }

    public static Hero getHero(String heroName) {
        Hero hero = new Hero();
        for (Hero h : heroBox) {
            if (h.name.equals(heroName) || h.chineseName.equals(heroName)) {
                hero.name = h.name;
                hero.chineseName = h.chineseName;
                hero.skill = h.skill;
            }
        }
        return hero;
    }

    public static Minion getMinion(String minionName) {
        Minion minion = new Minion();
        for (Minion m : minionBox) {
            if (m.name.equals(minionName) || m.chineseName.equals(minionName)) {
                minion.name = m.name;
                minion.chineseName = m.chineseName;
                minion.setAttack(m.attack);
                minion.setBlood(m.blood);
            }
        }
        return minion;
    }

    public static Weapon getWeapon(String weaponName) {
        return weaponBox.stream()
                .filter(p -> p.name.equals(weaponName))
                .findFirst()
                .orElse(null);
    }

    private <T> T getObject(List<T> box) {
        T t = box.stream()
                .filter((T)p -> p.name.equals(minionName))
                .findFirst()
                .orElse(null);

        Weapon r = new Weapon();
        BeanUtils.copyProperties(m, r);
        return r;
    }
}
