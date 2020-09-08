package com.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@RestController
public class SpringBootRibbonProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRibbonProviderApplication.class, args);
	}

	@GetMapping("/greet")
	public String greetings() {
		List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
		Random rand = new Random();
		int randomNum = rand.nextInt(greetings.size());
		return greetings.get(randomNum);
	}

	/*
	This is very important on the servers, whose instances
	are being balanced using ribbon on another service

	so, without this end-point you may get

	No Instances available for chatbook
	(in the service where ribbon load balancing is configured)
	 */
	@GetMapping("/")
	public String home(){
		return "reaching...";
	}

}
