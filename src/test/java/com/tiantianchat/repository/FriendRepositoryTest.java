package com.tiantianchat.repository;

import com.tiantianchat.heartstone.model.entity.FriendEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FriendRepositoryTest {

    @Autowired
    private FriendRepository friendRepository;

    @Test
    public void addFriend() {
        List<FriendEntity> friends = new ArrayList<>(1250000);
        for (int i = 0; i < 1000000; i++) {
            friends.add(new FriendEntity(55530, i));
        }

        long begin = System.currentTimeMillis();
        friendRepository.saveAll(friends);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    @Test
    public void find() {
    }
}