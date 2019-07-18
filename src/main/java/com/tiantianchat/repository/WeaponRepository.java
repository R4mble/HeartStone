package com.tiantianchat.repository;

import com.tiantianchat.model.heartstone.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wangyl
 * @date 2019/7/19
 */
@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer> {
    
}
