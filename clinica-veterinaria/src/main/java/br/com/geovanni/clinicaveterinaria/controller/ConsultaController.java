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

import br.com.geovanni.clinicaveterinaria.model.Consulta;
import br.com.geovanni.clinicaveterinaria.repository.ConsultaRepository;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaRepository repository;

    public ConsultaController(ConsultaRepository repository) {
        this.repository = repository;
    }


    @PostMapping
    public Consulta salvar(@RequestBody Consulta consulta) {
        return repository.save(consulta);
    }


    @GetMapping
    public List<Consulta> listar() {
        return repository.findAll();
    }


    @GetMapping("/{id}")
    public Consulta buscarPorId(@PathVariable Long id) {
        return repository.findById(id).get();
    }


    @PutMapping("/{id}")
    public Consulta atualizar(@PathVariable Long id, @RequestBody Consulta dadosConsulta) {

        Consulta consulta = repository.findById(id).get();

        consulta.setData(dadosConsulta.getData());
        consulta.setDescricao(dadosConsulta.getDescricao());
        consulta.setPet(dadosConsulta.getPet());
        consulta.setVeterinario(dadosConsulta.getVeterinario());

        return repository.save(consulta);
    }


    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id) {

        repository.deleteById(id);

        return "Consulta removida com sucesso!";
    }
}