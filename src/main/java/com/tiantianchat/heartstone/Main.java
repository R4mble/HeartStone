package com.tiantianchat.heartstone;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tiantianchat.heartstone.model.Hero;
import com.tiantianchat.heartstone.skill.Skill;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ramble
 */
public class Main {

    private static List<Hero> heroBox = new ArrayList<>();
    private static ObjectMapper mapper = new ObjectMapper();

    private static String DIR = "C:\\Users\\Ramble\\Desktop\\tiantianchat";
    private static String PATH = "\\src\\main\\java\\com\\tiantianchat\\heartstone\\CardDesc\\";

    public Main() throws IOException {
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
    }

    public static void main(String[] args) throws IOException {
        new Main();

        Hero paladin = getHero(heroBox, "Paladin");
        Hero war = getHero(heroBox, "战士");


    }

    private static Hero getHero(List<Hero> heroBox, String heroName) {
        return heroBox.stream()
                .filter(p -> p.getName().equals(heroName) || p.getChineseName().equals(heroName))
                .findFirst()
                .orElse(null);
    }
}
