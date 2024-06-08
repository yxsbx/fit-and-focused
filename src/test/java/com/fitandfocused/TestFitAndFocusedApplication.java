package com.fitandfocused;

import org.springframework.boot.SpringApplication;

public class TestFitAndFocusedApplication {

	public static void main(String[] args) {
		SpringApplication.from(FitAndFocusedApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
