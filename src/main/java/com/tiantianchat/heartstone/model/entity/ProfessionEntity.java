package com.tiantianchat.heartstone.model.entity;

import com.tiantianchat.heartstone.model.dto.Profession;
import lombok.Data;

import javax.persistence.*;

/**
 *
 *
 */
@Entity
@Table(name = "profession")
@Data
public class ProfessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String skill;

    public Profession toDTO() {
        return new Profession(name, skill);
    }
}
