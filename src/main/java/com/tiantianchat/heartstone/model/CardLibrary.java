package com.tiantianchat.heartstone.model;

import com.tiantianchat.heartstone.InitGame;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Wangyl
 * @date 2019/7/10
 */
@Data
@NoArgsConstructor
public class CardLibrary {

    List<Card> cardLibrary;

    public CardLibrary(Card... cards) {
        this.cardLibrary = Arrays.asList(cards);
    }

    public CardLibrary(String... cardName) {
//        cardLibrary = Arrays.asList(Arrays.stream(cardName).map(InitGame::getMinion).toArray());
    }

    public CardLibrary(List<Card> cards) {
        Collections.shuffle(cards);
        this.cardLibrary = cards;
    }

    public Card drawCard() {
        return cardLibrary.remove(0);
    }

    public int size() {
        return cardLibrary.size();
    }
}
