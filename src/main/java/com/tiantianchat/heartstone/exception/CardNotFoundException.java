package com.tiantianchat.heartstone.exception;

/**
 *
 */
public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException() {
        super("你没有该卡牌!");
    }
}
