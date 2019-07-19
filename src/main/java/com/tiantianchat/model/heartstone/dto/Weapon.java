package com.tiantianchat.model.heartstone.dto;

import com.tiantianchat.model.heartstone.Card;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Wangyl
 * @date 2019/7/19
 */
@Data
public class Weapon implements Card {
    private String name;
    private Integer attack;
    private Integer durability;
}
