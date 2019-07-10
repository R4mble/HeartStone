package com.tiantianchat.heartstone.exception;

/**
 * @author Wangyl
 * @date 2019/7/10
 */
public class ManaLessException extends RuntimeException {
    
    public ManaLessException() {
        super("法力值不够哎!");
    }
}