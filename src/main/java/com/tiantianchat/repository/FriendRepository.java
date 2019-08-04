package com.tiantianchat.repository;

import com.tiantianchat.heartstone.model.entity.FriendEntity;
import com.tiantianchat.heartstone.model.entity.MinionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *
 */
@Repository
public interface FriendRepository extends JpaRepository<FriendEntity, Integer> {

}
