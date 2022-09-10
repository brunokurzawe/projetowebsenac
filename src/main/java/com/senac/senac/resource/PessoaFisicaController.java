package com.senac.senac.resource;

import com.senac.senac.model.PessoaFisica;
import com.senac.senac.repository.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas-fisicas")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaRepository repository;

    @PostMapping
    public PessoaFisica create(@RequestBody PessoaFisica entity) {
        return repository.save(entity);
    }

    @GetMapping
    public List<PessoaFisica> listAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public PessoaFisica getById(@PathVariable(value = "id") Long id) {

        PessoaFisica entity = repository.findById(id)
                .orElse(new PessoaFisica());

        return entity;
    }

    @PutMapping("/{id}")
    public PessoaFisica update(@PathVariable(value = "id") Long id,
                         @RequestBody PessoaFisica entity) {
        PessoaFisica entityFind = repository.findById(id).orElse(null);
        if (entityFind != null) {
            entityFind.setId(entity.getId());
            entityFind.setNome(entity.getNome());
            entityFind.setCpf(entity.getCpf());
            entityFind.setRg(entity.getRg());
            entityFind.setNomeMae(entity.getNomeMae());
            entityFind.setNomePai(entity.getNomePai());
            entityFind.setDataCadastro(entity.getDataCadastro());
            return repository.save(entityFind);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) {
        PessoaFisica entity = repository.findById(id)
                .orElse(null);

        if (entity != null) {
            repository.delete(entity);
        }

        return ResponseEntity.noContent().build();
    }
    
}
