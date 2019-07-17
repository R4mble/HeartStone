package com.tiantianchat.heartstone.model;

import com.tiantianchat.heartstone.character.Minion;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wangyl
 * @date 2019/7/10
 */
public class HandCard {

    private List<Card> handCards = new ArrayList<>();

    public void addLast(List<Card> cards) {
        this.handCards.addAll(cards);
    }

    public void addLast(Card... cards) {
        this.handCards.addAll(Arrays.asList(cards));
    }

    public int size() {
        return handCards.size();
    }


    public boolean exist(String minionName) {
        for (Card card : handCards) {
            if (card instanceof Minion) {
                Minion m = (Minion)card;
                if (m.getChineseName().equals(minionName) || m.getName().equals(minionName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void remove(Card card) {
        this.handCards.remove(card);
    }


    @Override
    public String toString() {
        return handCards.toString();
    }

    public Minion getMinion(int i) {
        return (Minion)handCards.get(i);
    }
}
