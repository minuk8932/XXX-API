package com.datasaver.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableConfigurationProperties
public class DataSaverApplication {
	public static void main(String[] args) {
		SpringApplication.run(DataSaverApplication.class, args);
	}
}