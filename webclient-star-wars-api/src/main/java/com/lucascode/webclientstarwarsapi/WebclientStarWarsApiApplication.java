package com.lucascode.webclientstarwarsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@SpringBootApplication
@JsonAutoDetect
public class WebclientStarWarsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebclientStarWarsApiApplication.class, args);
	}

}
