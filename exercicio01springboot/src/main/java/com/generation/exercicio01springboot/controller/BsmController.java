package com.generation.exercicio01springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bsm-generation")

public class BsmController {
	@GetMapping
	public String listarBsm() {
		return 
				"Orientaçao ao Futuro\r\n"
				+ "Trabalho em Equipe\r\n"
				+ "Responsabilidade Pessoal\r\n"
				+ "Mentalidade de Crescimento\r\n"
				+ "Comunicação"
				+ "Persistência\r\n"
				+ "Habilidades\r\n"
				+ "Atenção aos Detalhes\r\n"
				+ "Proatividade\r\n";
				
				
	}
	
	

}
