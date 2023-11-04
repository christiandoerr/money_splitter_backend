package com.doerrchristian.money_splitter_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class MoneySplitterBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneySplitterBackendApplication.class, args);
	}

}
