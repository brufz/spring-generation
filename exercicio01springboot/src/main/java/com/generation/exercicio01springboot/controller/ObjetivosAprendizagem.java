package com.generation.exercicio01springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("objetivos-aprendizagem")

public class ObjetivosAprendizagem {
	@GetMapping
	public String listarObjetivosAprendizagem() {
		return "Os objetivos de aprendizagem da semana são: \n"
				+ "Spring Boot - Aprendizado durante a aula e revisão \n"
				+ "Finalizar vídeos de reforço sobre MySQL \nz"
				+ "Iniciar curso adicional de Spring Boot para revisão";
	}
}
