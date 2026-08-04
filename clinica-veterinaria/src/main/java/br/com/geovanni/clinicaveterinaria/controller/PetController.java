package br.com.geovanni.clinicaveterinaria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.geovanni.clinicaveterinaria.model.Pet;
import br.com.geovanni.clinicaveterinaria.repository.PetRepository;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetRepository repository;

    public PetController(PetRepository repository) {
        this.repository = repository;
    }


    @PostMapping
    public Pet salvar(@RequestBody Pet pet) {
        return repository.save(pet);
    }


    @GetMapping
    public List<Pet> listar() {
        return repository.findAll();
    }


    @GetMapping("/{id}")
    public Pet buscarPorId(@PathVariable Long id) {
        return repository.findById(id).get();
    }


    @PutMapping("/{id}")
    public Pet atualizar(@PathVariable Long id, @RequestBody Pet dadosPet) {

        Pet pet = repository.findById(id).get();

        pet.setNome(dadosPet.getNome());
        pet.setEspecie(dadosPet.getEspecie());
        pet.setIdade(dadosPet.getIdade());
        pet.setTutor(dadosPet.getTutor());

        return repository.save(pet);
    }


    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {

        repository.deleteById(id);

        return "Pet removido com sucesso!";
    }
}