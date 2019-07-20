package com.tiantianchat.heartstone.invoker;

import com.tiantianchat.heartstone.model.Card;
import com.tiantianchat.heartstone.model.dto.Profession;
import org.springframework.stereotype.Component;

/**
 * 抽牌器
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
