package com.tiantianchat.repository;

import com.tiantianchat.heartstone.model.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *
 */
@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

}
