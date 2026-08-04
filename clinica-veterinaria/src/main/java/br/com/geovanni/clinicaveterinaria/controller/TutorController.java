package br.com.geovanni.clinicaveterinaria.controller;

import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.geovanni.clinicaveterinaria.model.Tutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.geovanni.clinicaveterinaria.repository.TutorRepository;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    private final TutorRepository repository;

    public TutorController(TutorRepository repository) {
        this.repository = repository;
    }
    
    @PostMapping
    public Tutor salvar(@RequestBody Tutor tutor) {
        return repository.save(tutor);
    }

    @GetMapping("/{id}")
    public Tutor buscarPorId(@PathVariable Long id) {
        return repository.findById(id).get();
    }
    
    @PutMapping("/{id}")
    public Tutor atualizar(@PathVariable Long id, @RequestBody Tutor dadosTutor) {

        Tutor tutor = repository.findById(id).get();

        tutor.setNome(dadosTutor.getNome());
        tutor.setTelefone(dadosTutor.getTelefone());
        tutor.setEmail(dadosTutor.getEmail());

        return repository.save(tutor);
    }
    
    @GetMapping
    public List<Tutor> listar() {
        return repository.findAll();
    }
    
    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {

        repository.deleteById(id);

        return "Tutor removido com sucesso!";
    }
    
    
    
}