package com.tiantianchat.heartstone.exception;

/**
 * @author Wangyl
 * @date 2019/7/11
 */
public class AttackZeroException extends Throwable {

    public AttackZeroException() {
        super("攻击力为0, 无法攻击其他角色!");
    }
}
