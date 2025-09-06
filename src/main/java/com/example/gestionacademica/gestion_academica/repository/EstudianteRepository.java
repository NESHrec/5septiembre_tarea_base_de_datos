package com.example.gestionacademica.gestion_academica.repository;

import com.example.gestionacademica.gestion_academica.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {}