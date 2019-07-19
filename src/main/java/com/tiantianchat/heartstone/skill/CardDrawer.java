package com.tiantianchat.heartstone.skill;

import com.tiantianchat.model.heartstone.Card;
import com.tiantianchat.model.heartstone.dto.Profession;
import org.springframework.stereotype.Component;

/**
 * @author Wangyl
 * @date 2019/7/19
 */
@Component
public class CardDrawer {

    public void draw(Profession src, int num) {
        while (num != 0) {
            Card card = src.getCardLibrary().remove(0);
            src.getHandCard().add(card);
            num--;
        }
    }
}
