package br.com.geovanni.clinicaveterinaria.dto;

public class PetDTO {

    private String nome;

    public PetDTO() {
    }

    public PetDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}