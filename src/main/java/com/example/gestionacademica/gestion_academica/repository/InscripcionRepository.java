package com.example.gestionacademica.gestion_academica.repository;

import com.example.gestionacademica.gestion_academica.dto.CicloEstudianteCountDTO;
import com.example.gestionacademica.gestion_academica.dto.CursoNotaPromedioDTO;
import com.example.gestionacademica.gestion_academica.entity.Inscripcion;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    @Query("SELECT new com.example.gestionacademica.gestion_academica.dto.CursoNotaPromedioDTO(i.curso.nombre, AVG(i.notaFinal)) " +
           "FROM Inscripcion i GROUP BY i.curso.nombre")
    List<CursoNotaPromedioDTO> findAverageNotaByCurso();

    @Query("SELECT new com.example.gestionacademica.gestion_academica.dto.CicloEstudianteCountDTO(i.cicloAcademico, COUNT(DISTINCT i.estudiante.id)) " +
           "FROM Inscripcion i GROUP BY i.cicloAcademico")
    List<CicloEstudianteCountDTO> countEstudiantesByCiclo();

    @Query("SELECT new com.example.gestionacademica.gestion_academica.dto.CursoNotaPromedioDTO(i.curso.nombre, AVG(i.notaFinal)) " +
           "FROM Inscripcion i " +
           "GROUP BY i.curso.nombre " +
           "ORDER BY AVG(i.notaFinal) DESC")
    List<CursoNotaPromedioDTO> findTopCursosByNotaPromedio(Pageable pageable);
}