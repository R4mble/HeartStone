package com.tiantianchat.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Wangyl
 * @date 2019/7/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MinionRepositoryTest {

    @Autowired
    private MinionRepository minionRepository;

    @Test
    public void testFindByName() {
        minionRepository.findByName("报告兵");
    }
}