package com.tiantianchat.repository;

import com.tiantianchat.heartstone.model.entity.MinionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *
 */
@Repository
public interface MinionRepository extends JpaRepository<MinionEntity, Integer> {

    MinionEntity findByName(String name);
}
