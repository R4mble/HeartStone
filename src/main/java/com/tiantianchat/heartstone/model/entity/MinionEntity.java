package com.tiantianchat.heartstone.model.entity;

import com.tiantianchat.heartstone.model.Card;
import com.tiantianchat.heartstone.model.GameCharacter;
import com.tiantianchat.heartstone.model.dto.Minion;
import lombok.Data;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "minion")
@Data
public class MinionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer cost;
    private Integer attack;
    private Integer blood;
    private String battleCry;
    private String profession;

    public Minion toDTO() {
        return new Minion(name, cost, attack, blood, battleCry);
    }
}
