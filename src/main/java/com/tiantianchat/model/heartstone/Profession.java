package com.tiantianchat.model.heartstone;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Wangyl
 * @date 2019/7/18
 */
@Entity
@Data
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String chineseName;
    private String skill;
    private Integer attack;
    private Integer blood;
}
