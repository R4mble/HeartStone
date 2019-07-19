package com.tiantianchat.model.heartstone.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Map;

/**
 * @author Wangyl
 * @date 2019/7/16
 */
@Entity
@Table(name = "player")
@Data
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Integer goldCoin;
    @ElementCollection
    private Map<String, Integer> heroExperience;
    private PlayerEntity[] friends;
    private PlayerEntity[] blocks;
}
