package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TestController {

	@RequestMapping("/test")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@RequestMapping("/test2")
	public Test test() {
		Test t = new Test();
		t.value = "test";
		
		return t;
	}

}
