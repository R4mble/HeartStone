package com.tiantianchat.repository;

import com.tiantianchat.model.heartstone.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wangyl
 * @date 2019/7/17
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}
