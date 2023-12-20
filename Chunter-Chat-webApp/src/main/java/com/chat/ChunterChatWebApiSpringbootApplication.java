package com.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.chat.modal")
public class ChunterChatWebApiSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChunterChatWebApiSpringbootApplication.class, args);
	}

}
//this is my chunter chat appplication using springboot