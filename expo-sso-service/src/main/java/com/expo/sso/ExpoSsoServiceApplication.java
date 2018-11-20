package com.expo.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExpoSsoServiceApplication {

	public static void main(String[] args) {
	    SpringApplication.run(ExpoSsoServiceApplication.class, args);
	}
}
