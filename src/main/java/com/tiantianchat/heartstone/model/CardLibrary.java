package com.tiantianchat.heartstone.model;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author Wangyl
 * @date 2019/7/10
 */
@Data
public class CardLibrary {

    List<Card> cardLibrary;

    public CardLibrary(Card... cards) {
        this.cardLibrary = Arrays.asList(cards);
    }

    public CardLibrary(List<Card> cards) {
        this.cardLibrary = cards;
    }

    public Card drawCard() {
        return cardLibrary.remove(0);
    }

    public int size() {
        return cardLibrary.size();
    }
}
