package com.senac.senac.resource;

import com.senac.senac.model.Governante;
import com.senac.senac.repository.GovernanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/governantes")
public class GovernanteController {

    @Autowired
    private GovernanteRepository repository;

    @PostMapping
    public Governante create(@RequestBody Governante governante) {
        return repository.save(governante);
    }

    @GetMapping
    public List<Governante> listAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Governante getPaisesId(@PathVariable(value = "id") Long id) {

        Governante governante = repository.findById(id)
                .orElse(new Governante());

        return governante;
    }

    @PutMapping("/{id}")
    public Governante update(@PathVariable(value = "id") Long id,
                             @RequestBody Governante governante) {
        Governante governanteFind = repository.findById(id).orElse(null);
        if (governanteFind != null) {
            governanteFind.setId(governante.getId());
            governanteFind.setNome(governante.getNome());
            governanteFind.setCargo(governante.getCargo());

            return repository.save(governanteFind);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) {
        Governante governante = repository.findById(id)
                .orElse(null);

        if (governante != null) {
            repository.delete(governante);
        }

        return ResponseEntity.noContent().build();
    }
}
