package br.com.geovanni.clinicaveterinaria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.geovanni.clinicaveterinaria.dto.Mensagem;
import br.com.geovanni.clinicaveterinaria.dto.PetDTO;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public Mensagem hello() {
		return new Mensagem ("Olá!");
	}
	
	@PostMapping("/pets")
	public PetDTO criarPet(@RequestBody PetDTO pet) {
				
		return pet;
	}
	
}