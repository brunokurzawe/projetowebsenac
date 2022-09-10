package com.senac.senac.resource;

import com.senac.senac.model.Cidade;
import com.senac.senac.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository repository;

    @PostMapping
    public Cidade create(@RequestBody Cidade entity) {
        return repository.save(entity);
    }

    @GetMapping
    public List<Cidade> listAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Cidade getById(@PathVariable(value = "id") Long id) {

        Cidade entity = repository.findById(id)
                .orElse(new Cidade());

        return entity;
    }

    @PutMapping("/{id}")
    public Cidade update(@PathVariable(value = "id") Long id,
                         @RequestBody Cidade entity) {
        Cidade entityFind = repository.findById(id).orElse(null);
        if (entityFind != null) {
            entityFind.setId(entity.getId());
            entityFind.setNome(entity.getNome());
            entityFind.setLatitude(entity.getLatitude());
            entityFind.setLongitude(entity.getLongitude());
            entityFind.setPopulacao(entity.getPopulacao());
            entityFind.setEstado(entity.getEstado());
            return repository.save(entityFind);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) {
        Cidade entity = repository.findById(id)
                .orElse(null);

        if (entity != null) {
            repository.delete(entity);
        }

        return ResponseEntity.noContent().build();
    }

}
