package com.example.timesheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootApplication
public class TimesheetApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimesheetApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("*").allowedOrigins("http://localhost:8080","http://127.0.0.1").allowedMethods("*").maxAge(3600).allowedHeaders("Requestor-Type").exposedHeaders("X-Get-Header");
//			}
//		};
//	}
//	@Bean
//	public SecurityFilterChain sfc(HttpSecurity http) throws Exception {
//		http.cors();
//		return http.build();
//	}
}

