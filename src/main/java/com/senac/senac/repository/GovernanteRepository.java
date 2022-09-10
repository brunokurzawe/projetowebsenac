package com.senac.senac.repository;

import com.senac.senac.model.Governante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GovernanteRepository extends JpaRepository<Governante, Long> {

}