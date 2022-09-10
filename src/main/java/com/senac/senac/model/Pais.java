package com.senac.senac.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="NOME")
    private String nome;

    @Column(name = "SIGLA")
    private String sigla;

    @Column(name="POPULACAO")
    private Double populacao;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
    private List<Governante> governantes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Double getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Double populacao) {
        this.populacao = populacao;
    }

    public List<Governante> getGovernantes() {
        return governantes;
    }

    public void setGovernantes(List<Governante> governantes) {
        this.governantes = governantes;
    }


}
