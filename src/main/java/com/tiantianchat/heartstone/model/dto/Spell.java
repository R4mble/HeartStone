package com.tiantianchat.heartstone.model.dto;

import com.tiantianchat.heartstone.model.Card;
import lombok.Data;

/**
 *
 *
 */
@Data
public class Spell implements Card {
    private String name;
    private Integer cost;
    private String profession;
}
