package com.senac.senac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PessoaJuridica extends Pessoa {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "INSCRICAO_ESTADUAL")
    private String incrEstadual;

    @Column(name = "INSCRICAO_MUNICIPAL")
    private String incrMunicipal;

    @Column(name = "CNPJ")
    private String cnpj;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIncrEstadual() {
        return incrEstadual;
    }

    public void setIncrEstadual(String incrEstadual) {
        this.incrEstadual = incrEstadual;
    }

    public String getIncrMunicipal() {
        return incrMunicipal;
    }

    public void setIncrMunicipal(String incrMunicipal) {
        this.incrMunicipal = incrMunicipal;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
