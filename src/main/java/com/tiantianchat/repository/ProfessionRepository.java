package com.tiantianchat.repository;

import com.tiantianchat.model.heartstone.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Wangyl
 * @date 2019/7/18
 */
@Repository
public interface ProfessionRepository extends JpaRepository<Profession, Integer> {

}
