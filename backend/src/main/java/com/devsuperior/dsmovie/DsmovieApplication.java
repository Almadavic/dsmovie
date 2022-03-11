package com.devsuperior.dsmovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DsmovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsmovieApplication.class, args);
	}

}
