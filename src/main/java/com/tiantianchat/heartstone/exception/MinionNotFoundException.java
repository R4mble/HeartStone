package com.tiantianchat.heartstone.exception;

/**
 * @author Ramble
 */
public class MinionNotFoundException extends RuntimeException {

    public MinionNotFoundException() {
        super("你没有该随从!");
    }
}
