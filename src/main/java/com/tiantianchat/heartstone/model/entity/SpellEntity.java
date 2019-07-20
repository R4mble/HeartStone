package com.tiantianchat.heartstone.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 *
 *
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
