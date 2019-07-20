package com.tiantianchat.repository;

import com.tiantianchat.heartstone.model.entity.ProfessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *
 */
@Repository
public interface ProfessionRepository extends JpaRepository<ProfessionEntity, Integer> {

    ProfessionEntity findByName(String name);
}
