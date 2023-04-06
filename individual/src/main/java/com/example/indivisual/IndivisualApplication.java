package com.example.indivisual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class IndivisualApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndivisualApplication.class, args);
	}

}
