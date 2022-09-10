package com.senac.senac.resource;

import com.senac.senac.model.Pais;
import com.senac.senac.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    private PaisRepository repository;

    @PostMapping
    public Pais create(@RequestBody Pais pais) {
        return repository.save(pais);
    }

    @GetMapping
    public List<Pais> listAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Pais getPaisesId(@PathVariable(value = "id") Long id) {

        Pais paisFind = repository.findById(id)
                .orElse(new Pais());

        return paisFind;
    }

    @PutMapping("/{id}")
    public Pais update(@PathVariable(value = "id") Long paisId,
                       @RequestBody Pais pais) {
        Pais paisFind = repository.findById(paisId).orElse(null);
        if (paisFind != null) {
            paisFind.setId(pais.getId());
            paisFind.setNome(pais.getNome());
            paisFind.setPopulacao(pais.getPopulacao());

            return repository.save(paisFind);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long paisId) {
        Pais paisFind = repository.findById(paisId)
                .orElse(null);

        if (paisFind != null) {
            repository.delete(paisFind);
        }

        return ResponseEntity.noContent().build();
    }

}
