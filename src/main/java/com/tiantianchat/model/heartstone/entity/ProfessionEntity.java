package com.tiantianchat.model.heartstone.entity;

import com.tiantianchat.model.heartstone.dto.Profession;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Wangyl
 * @date 2019/7/18
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
