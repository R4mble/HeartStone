package com.tiantianchat.model.heartstone;

import lombok.Data;

import javax.persistence.*;
import java.util.Map;

/**
 * @author Wangyl
 * @date 2019/7/16
 */
@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Integer goldCoin;
    @ElementCollection
    private Map<String, Integer> heroExperience;
    private Player[] friends;
    private Player[] blocks;
}
