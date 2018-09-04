package com.rao.test.productinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class ProductInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductInfoApplication.class, args);
	}
}
