package com.test.demo;

import com.test.demo.hello.GreetingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner greetingCommandLine(GreetingService GreetingService) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				GreetingService.greet("Spring");
			}
		};
	}
}
