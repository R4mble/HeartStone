package com.tiantianchat.heartstone.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Map;

/**
 *
 *
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
