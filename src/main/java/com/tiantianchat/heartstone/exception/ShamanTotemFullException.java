package com.tiantianchat.heartstone.exception;

/**
 *
 *
 */
public class ShamanTotemFullException extends RuntimeException {

    public ShamanTotemFullException() {
        super("你的图腾已经满了, 不能再转了!");
    }
}
