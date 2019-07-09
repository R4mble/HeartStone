package com.tiantianchat.heartstone;

import com.tiantianchat.heartstone.model.Hero;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Ramble
 */
public class HeroFactory extends ArrayList {

    public Hero getHero(String heroName) {
        this.stream().forEach(System.out::println);
        return null;
    }
}
