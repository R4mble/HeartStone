package com.tiantianchat.model.heartstone.entity;

import com.tiantianchat.model.heartstone.Card;
import com.tiantianchat.model.heartstone.Character;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * @author Wangyl
 * @date 2019/7/18
 */
@Entity
@Data
public class ProfessionEntity implements Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String skill;
}
