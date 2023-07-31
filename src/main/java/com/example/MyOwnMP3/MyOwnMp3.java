package com.example.MyOwnMP3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class MyOwnMp3 {

	public static void main(String[] args) {
		SpringApplication.run(MyOwnMp3.class, args);
	}
}
