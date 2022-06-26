package com.example.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaClient
@Slf4j
public class EurekaClientApplication {

	@Value("${server.port}")
	private String serverPort;

	private static String serverPortStatic;

	@Value("${server.port}")
	public void setServerPortStatic(String serverPort) {
		EurekaClientApplication.serverPortStatic = serverPort;
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
		log.info("Eureka Client runnig on port: {}", serverPortStatic);
	}

}
