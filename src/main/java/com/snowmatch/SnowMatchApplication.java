package com.snowmatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SnowMatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnowMatchApplication.class, args);
	}

}
