package br.com.geovanni.clinicaveterinaria.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.geovanni.clinicaveterinaria.model.Veterinario;
import br.com.geovanni.clinicaveterinaria.repository.VeterinarioRepository;

import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/veterinarios")
public class VeterinarioController {

    private final VeterinarioRepository repository;

    public VeterinarioController(VeterinarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Veterinario salvar(@RequestBody Veterinario veterinario) {
        return repository.save(veterinario);
    }
    
    @GetMapping
    public List<Veterinario> listar() {
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public Veterinario buscarPorId(@PathVariable Long id) {
        return repository.findById(id).get();
    }
    
    @PutMapping("/{id}")
    public Veterinario atualizar(@PathVariable Long id, @RequestBody Veterinario dadosVeterinario) {

        Veterinario veterinario = repository.findById(id).get();

        veterinario.setNome(dadosVeterinario.getNome());
        veterinario.setCrmv(dadosVeterinario.getCrmv());
        veterinario.setEspecialidade(dadosVeterinario.getEspecialidade());

        return repository.save(veterinario);
    }
    
    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {

        repository.deleteById(id);

        return "Veterinário removido com sucesso!";
    }

}