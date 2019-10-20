package com.wuyang.dubbodemoserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:*.xml")
public class DubboDemoServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboDemoServiceProviderApplication.class, args);
	}

}
