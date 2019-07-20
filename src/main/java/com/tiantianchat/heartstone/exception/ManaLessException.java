package com.tiantianchat.heartstone.exception;

/**
 *
 *
 */
public class ManaLessException extends RuntimeException {
    
    public ManaLessException() {
        super("法力值不够哎!");
    }
}