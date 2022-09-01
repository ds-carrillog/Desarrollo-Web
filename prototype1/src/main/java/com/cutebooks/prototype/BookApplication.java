package com.cutebooks.prototype;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

// @SpringBootApplication // Equivale a:
@Configuration // Para crear custom beans
@EnableAutoConfiguration // Para cargar beans de librerías en el classpath
// Para escanear clases anotadas con @Component, @Controller,
// @Service, and @Repository y cargarlas como beans en memoria
@ComponentScan
// @ComponentScan (basePackages={"com.example.example2"})

public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

	@Bean
	// https://www.baeldung.com/java-resourcebundle
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages-es");
		return messageSource;
	}
}
