package com.dagong.springboot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloWorldController {

	@RequestMapping("/home")
	@ResponseBody
	public String home() {
		System.out.println("test...");
		return HelloWorldController.class.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldController.class, args);
	}
}
