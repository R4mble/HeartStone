package com.tiantianchat.repository;

import com.tiantianchat.model.heartstone.dto.Weapon;
import com.tiantianchat.model.heartstone.entity.WeaponEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wangyl
 * @date 2019/7/19
 */
@Repository
public interface WeaponRepository extends JpaRepository<WeaponEntity, Integer> {

    WeaponEntity findByName(String name);
}
