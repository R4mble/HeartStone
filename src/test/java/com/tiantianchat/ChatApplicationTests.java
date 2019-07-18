package com.tiantianchat;

import com.tiantianchat.repository.PlayerRepository;
import com.tiantianchat.repository.ProfessionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatApplicationTests {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private ProfessionRepository professionRepository;

	@Test
	public void test() throws IOException {

	}

}
