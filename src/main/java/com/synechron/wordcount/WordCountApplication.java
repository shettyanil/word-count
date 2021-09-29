package com.synechron.wordcount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.synechron.wordcount")
public class WordCountApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordCountApplication.class, args);
	}

}
