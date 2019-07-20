package com.tiantianchat.heartstone.exception;

/**
 *
 */
public class SceneFullException extends RuntimeException {

    public SceneFullException() {
        super("你的场面已经满了,不能再加了!");
    }
}
