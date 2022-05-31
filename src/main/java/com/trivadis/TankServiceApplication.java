package com.trivadis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@Configuration
//@ComponentScan(basePackages = "com.trivadis")
//@EnableAutoConfiguration
public class TankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TankServiceApplication.class, args);
	}

}
