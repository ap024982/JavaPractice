package com.example.CurrencyConvertFeignClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConvertFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConvertFeignClientApplication.class, args);
	}

}
