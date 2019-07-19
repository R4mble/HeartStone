package com.tiantianchat.model.heartstone.entity;

import com.tiantianchat.model.heartstone.Card;
import com.tiantianchat.model.heartstone.GameCharacter;
import com.tiantianchat.model.heartstone.dto.Minion;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Wangyl
 * @date 2019/7/19
 */
@Entity
@Table(name = "minion")
@Data
public class MinionEntity implements Card, GameCharacter {
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
