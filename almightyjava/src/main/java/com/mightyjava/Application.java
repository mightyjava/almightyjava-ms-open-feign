package com.mightyjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.mightyjava.captcha.CaptchaDetailsSource;
import com.mightyjava.captcha.CaptchaGenerator;
import com.mightyjava.listener.CounterApplicationListener;

@SpringBootApplication
@EnableFeignClients
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CaptchaGenerator getCaptchaGenerator() {
		return new CaptchaGenerator();
	}

	@Bean
	public CounterApplicationListener getCounterApplicationListener() {
		return new CounterApplicationListener();
	}

	@Bean
	public CaptchaDetailsSource getCaptchaDetailsSource() {
		return new CaptchaDetailsSource();
	}

}