package com.tiantianchat.model.heartstone.entity;

import com.tiantianchat.model.heartstone.Card;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Wangyl
 * @date 2019/7/19
 */
@Entity
@Table(name = "spell")
@Data
public class SpellEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer cost;
    private String profession;
}
