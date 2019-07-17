package com.tiantianchat.model;

import lombok.Data;

import java.util.Map;

/**
 * @author Wangyl
 * @date 2019/7/16
 */
@Data
public class Player {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Integer goldCoin;
    private Map<String, Integer> heroExperience;
    private Player[] friends;
    private Player[] blocks;
}
