package com.example.gestionacademica.gestion_academica.repository;

import com.example.gestionacademica.gestion_academica.dto.ProfesorCursoCountDTO;
import com.example.gestionacademica.gestion_academica.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Query("SELECT new com.example.gestionacademica.gestion_academica.dto.ProfesorCursoCountDTO(c.profesor.nombre, COUNT(c)) " +
           "FROM Curso c GROUP BY c.profesor.nombre")
    List<ProfesorCursoCountDTO> countCursosByProfesor();
}