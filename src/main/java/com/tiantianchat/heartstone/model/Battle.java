package com.tiantianchat.heartstone.model;

import com.tiantianchat.heartstone.character.Hero;
import lombok.Data;

/**
 * @author Wangyl
 * @date 2019/7/10
 */
@Data
public class Battle {
    private Hero hero1;
    private Hero hero2;

    public void begin() {
        hero1.drawCard(4);
        hero2.drawCard(4);
    }
}
