package br.com.geovanni.clinicaveterinaria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.geovanni.clinicaveterinaria.dto.Mensagem;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public Mensagem hello() {
		return new Mensagem ("Olá!");
	}
	
}
