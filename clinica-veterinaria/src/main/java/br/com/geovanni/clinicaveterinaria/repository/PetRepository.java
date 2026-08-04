package br.com.geovanni.clinicaveterinaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.geovanni.clinicaveterinaria.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}