package com.tiantianchat.service;

import com.tiantianchat.heartstone.model.entity.PlayerEntity;
import com.tiantianchat.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 */
@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public boolean createUser(String name, String email, String password) {
        return false;
    }

    public PlayerEntity login(String nameOrEmail, String password) {
        return null;
    }
}
