package com.tiantianchat.repository;

import com.tiantianchat.heartstone.model.entity.SpellEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellRepository extends JpaRepository<SpellEntity, Integer> {

    SpellEntity findByName(String name);
}
