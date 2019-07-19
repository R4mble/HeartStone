package com.tiantianchat.model.heartstone.entity;

import com.tiantianchat.model.heartstone.dto.Weapon;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Wangyl
 * @date 2019/7/19
 */
@Entity
@Table(name = "weapon")
@Data
public class WeaponEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer attack;
    private Integer durability;

    public Weapon toDTO() {
        return new Weapon(name, attack, durability);
    }
}
