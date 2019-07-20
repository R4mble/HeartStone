package com.tiantianchat.heartstone.model.entity;

import com.tiantianchat.heartstone.model.dto.Weapon;
import lombok.Data;

import javax.persistence.*;

/**
 *
 *
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
