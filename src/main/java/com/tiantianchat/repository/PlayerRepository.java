package com.tiantianchat.repository;

import com.tiantianchat.model.heartstone.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wangyl
 * @date 2019/7/17
 */
@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

}
