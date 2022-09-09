package com.capg.bookingmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages = "com.capg.bookingmicroservice.entity")
@ComponentScan(basePackages = "com.capg.bookingmicroservice.controller")
@ComponentScan(basePackages = "com.capg.bookingmicroservice.service")
@ComponentScan(basePackages = "com.capg.bookingmicroservice.dto")
@EnableMongoRepositories("com.capg.bookingmicroservice.repository") 
@EnableEurekaClient
@EnableCircuitBreaker

public class BookingMicroServiceApplication {
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(3000);
		return new RestTemplate(clientHttpRequestFactory);
	}
	
	 
	public static void main(String[] args) {
		SpringApplication.run(BookingMicroServiceApplication.class, args);
	}

}
