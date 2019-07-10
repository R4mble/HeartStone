package com.tiantianchat.heartstone.skill;

import java.lang.annotation.*;

/**
 * @author Wangyl
 * @date 2019/7/10
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ManaCost {

    int value();

    String desc();
}
