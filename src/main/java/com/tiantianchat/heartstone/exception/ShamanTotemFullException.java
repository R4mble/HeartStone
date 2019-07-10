package com.tiantianchat.heartstone.exception;

/**
 * @author Wangyl
 * @date 2019/7/10
 */
public class ShamanTotemFullException extends RuntimeException {

    public ShamanTotemFullException() {
        super("你的图腾已经满了, 不能再转了!");
    }
}
