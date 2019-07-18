package com.tiantianchat.heartstone;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiantianchat.heartstone.character.Hero;
import com.tiantianchat.heartstone.character.Minion;
import com.tiantianchat.heartstone.model.Weapon;
import com.tiantianchat.repository.MinionRepository;
import com.tiantianchat.repository.ProfessionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ramble
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class InitGame {

    private static List<Hero> heroBox = new ArrayList<>();
    private static List<Minion> minionBox = new ArrayList<>();
    private static List<Weapon> weaponBox = new ArrayList<>();
    private static ObjectMapper mapper = new ObjectMapper();

    private static String DIR = "C:\\Users\\Ramble\\Desktop\\tiantianchat";
    private static String SHENZHOUDIR = "C:\\Users\\Ramble\\Desktop\\MyGitHub\\HeartStone";
    private static String PATH = "\\src\\main\\resources\\";

    public InitGame() {
    }

    @Before
    public void InitGame() {

        DIR = SHENZHOUDIR;

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

    @Autowired
    private ProfessionRepository professionRepository;

    @Autowired
    private MinionRepository minionRepository;

    @Test
    public void init() {
        List<com.tiantianchat.model.heartstone.Minion> list = new ArrayList<>();

        for (Minion h : minionBox) {
            com.tiantianchat.model.heartstone.Minion p = new com.tiantianchat.model.heartstone.Minion();
            p.setName(h.name);
            p.setAttack(h.attack);
            p.setBlood(h.blood);
            p.setCost(h.cost);
            list.add(p);
        }

        minionRepository.saveAll(list);
    }


    public static Hero getHero(String a) {
        return null;
    }

    public static Minion getMinion(String a) {
        return null;
    }

    public static Weapon getWeapon(String a) {
        return null;
    }

}
