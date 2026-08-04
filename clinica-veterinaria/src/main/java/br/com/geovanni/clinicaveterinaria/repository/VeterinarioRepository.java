package br.com.geovanni.clinicaveterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geovanni.clinicaveterinaria.model.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {

}