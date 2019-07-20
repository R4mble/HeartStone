package com.tiantianchat.heartstone.exception;

/**
 *
 *
 */
public class AttackZeroException extends Throwable {

    public AttackZeroException() {
        super("攻击力为0, 无法攻击其他角色!");
    }
}
