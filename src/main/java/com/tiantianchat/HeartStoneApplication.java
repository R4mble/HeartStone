package com.tiantianchat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ramble
 */
@SpringBootApplication
@RestController
@EnableAspectJAutoProxy
public class HeartStoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeartStoneApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

}
