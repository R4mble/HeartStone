package com.tiantianchat.heartstone.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "friend")
@Data
@NoArgsConstructor
public class FriendEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer uid;
    private Integer fid;

    public FriendEntity(Integer uid, Integer fid) {
        this.uid = uid;
        this.fid = fid;
    }
}
