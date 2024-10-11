package com.example.Task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCaching
public class TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

}
