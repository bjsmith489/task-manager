package com.example.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync

public class TodolistApplication {

	//   Does this work?
	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

}
