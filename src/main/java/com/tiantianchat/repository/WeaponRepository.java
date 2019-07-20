package com.tiantianchat.repository;

import com.tiantianchat.heartstone.model.entity.WeaponEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 *
 */
@Repository
public interface WeaponRepository extends JpaRepository<WeaponEntity, Integer> {

    WeaponEntity findByName(String name);
}
