package com.cutebooks.prototype1;
import com.cutebooks.prototype1.database.Database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@EnableAutoConfiguration 
@ComponentScan

public class Prototype1Application {

	public static void main(String[] args) {
		SpringApplication.run(Prototype1Application.class, args);
	}

	@Bean
	public Database crearDB() {
		return new Database();
	}

	@Bean
	// https://www.baeldung.com/java-resourcebundle
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages-es");
		return messageSource;
	}
}
