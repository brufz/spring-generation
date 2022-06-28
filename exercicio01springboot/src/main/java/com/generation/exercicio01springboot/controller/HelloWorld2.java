package com.generation.exercicio01springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello-world-2")


public class HelloWorld2 {
	@GetMapping
	public String HelloWorld02() {
		return "Hello World!!";
	}

	
}
