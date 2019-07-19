package com.tiantianchat.model.heartstone;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Wangyl
 * @date 2019/7/19
 */
@Entity
@Data
public class Weapon implements Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer attack;
    private Integer durability;
}
