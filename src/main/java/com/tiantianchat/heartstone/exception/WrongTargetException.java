package com.tiantianchat.heartstone.exception;

public class WrongTargetException extends RuntimeException {

    public WrongTargetException() {
        super("你指定的目标不对!");
    }
}
