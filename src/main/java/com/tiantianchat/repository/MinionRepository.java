package com.tiantianchat.repository;

import com.tiantianchat.model.heartstone.Minion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wangyl
 * @date 2019/7/19
 */
@Repository
public interface MinionRepository extends JpaRepository<Minion, Integer> {

}
