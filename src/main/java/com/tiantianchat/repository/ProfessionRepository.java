package com.tiantianchat.repository;

import com.tiantianchat.model.heartstone.entity.ProfessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wangyl
 * @date 2019/7/18
 */
@Repository
public interface ProfessionRepository extends JpaRepository<ProfessionEntity, Integer> {

    ProfessionEntity findByName(String name);
}