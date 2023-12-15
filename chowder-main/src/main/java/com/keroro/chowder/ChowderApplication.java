package com.keroro.chowder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Keroro
 */
@SpringBootApplication
@ComponentScan("com.drools")
@MapperScan("com.keroro.chowder.dao.*")
public class ChowderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChowderApplication.class, args);
	}

}
