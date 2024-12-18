package com.practo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PractoApplication<ModelMapper> {

	public static void main(String[] args)
	{
		SpringApplication.run(PractoApplication.class, args);
	}
}

