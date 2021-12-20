package com.example.mailsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class MailsensderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailsensderApplication.class, args);
	}

}
