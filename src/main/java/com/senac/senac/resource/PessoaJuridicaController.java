package com.senac.senac.resource;

import com.senac.senac.model.PessoaJuridica;
import com.senac.senac.repository.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas-juridicas")
public class PessoaJuridicaController {

    @Autowired
    private PessoaJuridicaRepository repository;

    @PostMapping
    public PessoaJuridica create(@RequestBody PessoaJuridica entity) {
        return repository.save(entity);
    }

    @GetMapping
    public List<PessoaJuridica> listAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public PessoaJuridica getById(@PathVariable(value = "id") Long id) {

        PessoaJuridica entity = repository.findById(id)
                .orElse(new PessoaJuridica());

        return entity;
    }

    @PutMapping("/{id}")
    public PessoaJuridica update(@PathVariable(value = "id") Long id,
                                 @RequestBody PessoaJuridica entity) {
        PessoaJuridica entityFind = repository.findById(id).orElse(null);
        if (entityFind != null) {
            entityFind.setId(entity.getId());
            entityFind.setNome(entity.getNome());
            entityFind.setDataCadastro(entity.getDataCadastro());
            entityFind.setCnpj(entity.getCnpj());
            entityFind.setIncrEstadual(entity.getIncrEstadual());
            entityFind.setIncrMunicipal(entity.getIncrMunicipal());
            entityFind.setEndereco(entity.getEndereco());
            return repository.save(entityFind);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) {
        PessoaJuridica entity = repository.findById(id)
                .orElse(null);

        if (entity != null) {
            repository.delete(entity);
        }

        return ResponseEntity.noContent().build();
    }

}
