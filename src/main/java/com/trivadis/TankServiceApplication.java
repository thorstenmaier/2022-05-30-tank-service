package com.trivadis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

//@Configuration
//@ComponentScan(basePackages = "com.trivadis")
//@EnableAutoConfiguration
public class TankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TankServiceApplication.class, args);
	}

}
