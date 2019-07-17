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
            h.setName(o1.get("name").toString());
            h.setSkill(o1.get("skill").toString());
            h.setChineseName(o1.get("chineseName").toString());
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
            m.setName(o1.get("name").toString());
            m.setChineseName(o1.get("chineseName").toString());
            m.setAttack(Integer.parseInt(o1.get("attack").toString()));
            m.setBlood(Integer.parseInt(o1.get("blood").toString()));
            m.setCurBlood(Integer.parseInt(o1.get("blood").toString()));
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
            m.setName(o1.get("name").toString());
            m.setAttack(Integer.parseInt(o1.get("attack").toString()));
            m.setDurability(Integer.parseInt(o1.get("durability").toString()));
            weaponBox.add(m);
        }

    }

    public static Hero getHero(String heroName) {
        Hero h = heroBox.stream()
                    .filter(p -> p.getName().equals(heroName) || p.getChineseName().equals(heroName))
                    .findFirst()
                    .orElse(null);

        Hero r = new Hero();
        BeanUtils.copyProperties(h, r);
        return r;
    }

    public static Minion getMinion(String minionName) {
        Minion m = minionBox.stream()
                .filter(p -> p.getName().equals(minionName) || p.getChineseName().equals(minionName))
                .findFirst()
                .orElse(null);

        Minion r = new Minion();
        BeanUtils.copyProperties(m, r);
        return r;
    }

    public static Weapon getWeapon(String weaponName) {
        Weapon m = weaponBox.stream()
                .filter(p -> p.getName().equals(weaponName))
                .findFirst()
                .orElse(null);

        Weapon r = new Weapon();
        BeanUtils.copyProperties(m, r);
        return r;
    }

//    private <T> T getObject(List<T> box) {
//        T t = box.stream()
//                .filter((T)p -> p.getName().equals(minionName))
//                .findFirst()
//                .orElse(null);
//
//        Weapon r = new Weapon();
//        BeanUtils.copyProperties(m, r);
//        return r;
//    }
}
