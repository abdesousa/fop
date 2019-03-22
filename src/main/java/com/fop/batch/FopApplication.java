package com.fop.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Class responsible to run the spring boot application.
 * TODO Why should I use autoconfiguration???
 * @author Alexandre Sousa (abdesousa@gmail.com)
 */
@SpringBootApplication
public class FopApplication {

	public static void main(String[] args) {
		SpringApplication.run(FopApplication.class, args);
	}

}
