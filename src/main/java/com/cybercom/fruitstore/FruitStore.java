package com.cybercom.fruitstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FruitStore {

	//private static final Logger logger  = LoggerFactory.getLogger(FruitStore.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(FruitStore.class, args);
	}

}
