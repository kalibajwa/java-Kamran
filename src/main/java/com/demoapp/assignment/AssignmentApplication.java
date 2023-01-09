package com.demoapp.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(
		scanBasePackages = {
				"com.demoapp.assignment.*"
		}
)
public class AssignmentApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}
}
