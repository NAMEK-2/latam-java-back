package com.LATAM.birthdate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@SpringBootApplication
@ServletComponentScan
public class BirthdateApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirthdateApplication.class, args);
	}

}
