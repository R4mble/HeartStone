package com.tiantianchat.heartstone;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiantianchat.heartstone.character.Minion;
import com.tiantianchat.heartstone.character.Hero;
import com.tiantianchat.heartstone.test.SkillTest;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Ramble
 */
@Component
public class Main {

    private static List<Hero> heroBox = new ArrayList<>();
    private static List<Minion> minionBox = new ArrayList<>();
    private static ObjectMapper mapper = new ObjectMapper();

    private static String DIR = "C:\\Users\\Ramble\\Desktop\\tiantianchat";
    private static String COMDIR = "C:\\Users\\Windows\\Desktop\\HeartStone";
    private static String PATH = "\\src\\main\\java\\com\\tiantianchat\\heartstone\\CardDesc\\";

    public Main() throws IOException {

        DIR = COMDIR;

        File heroJsonFile = new File(DIR + PATH + "hero.json");
        List heroList = mapper.readValue(heroJsonFile, List.class);

        for (Object o : heroList) {
            Hero h = new Hero();
            Map o1 = (Map) o;

            h.setName(o1.get("name").toString());
            h.setSkill(o1.get("skill").toString());
            h.setChineseName(o1.get("chineseName").toString());

            heroBox.add(h);
        }


        File minionJsonFile = new File(DIR + PATH + "minion.json");
        List minionList = mapper.readValue(minionJsonFile, List.class);

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

    }

    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {


//
//        paladin.setCrystal(1);
//        paladin.invokeSkill();
//        System.out.println(paladin.getScene());
//        System.out.println(paladin.getCrystal());
//

        new Main();
        SkillTest skillTest = new SkillTest();
        Method[] methods = skillTest.getClass().getDeclaredMethods();
        for (Method m : methods) {
            m.invoke(skillTest);
        }
    }

    public static Hero getHero(String heroName) {
        return heroBox.stream()
                .filter(p -> p.getName().equals(heroName) || p.getChineseName().equals(heroName))
                .findFirst()
                .orElse(null);
    }

    public static Minion getMinion(String minionName) {
        return minionBox.stream()
                .filter(p -> p.getName().equals(minionName) || p.getChineseName().equals(minionName))
                .findFirst()
                .orElse(null);
    }
}
