package br.com.geovanni.clinicaveterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geovanni.clinicaveterinaria.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

}