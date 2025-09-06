package com.example.gestionacademica.gestion_academica.service;

import com.example.gestionacademica.gestion_academica.dto.CicloEstudianteCountDTO;
import com.example.gestionacademica.gestion_academica.dto.CursoNotaPromedioDTO;
import com.example.gestionacademica.gestion_academica.dto.ProfesorCursoCountDTO;
import com.example.gestionacademica.gestion_academica.repository.CursoRepository;
import com.example.gestionacademica.gestion_academica.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ReporteService {

    private final CursoRepository cursoRepository;
    private final InscripcionRepository inscripcionRepository;

    @Autowired
    public ReporteService(CursoRepository cursoRepository, InscripcionRepository inscripcionRepository) {
        this.cursoRepository = cursoRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    @Transactional(readOnly = true)
    public List<ProfesorCursoCountDTO> getProfesorCursoCounts() {
        return cursoRepository.countCursosByProfesor();
    }

    @Transactional(readOnly = true)
    public List<CursoNotaPromedioDTO> getCursoNotaPromedio() {
        return inscripcionRepository.findAverageNotaByCurso();
    }

    @Transactional(readOnly = true)
    public List<CicloEstudianteCountDTO> getEstudiantesPorCiclo() {
        return inscripcionRepository.countEstudiantesByCiclo();
    }

    @Transactional(readOnly = true)
    public List<CursoNotaPromedioDTO> getTopCursosPorNota() {
        Pageable topThree = PageRequest.of(0, 3);
        return inscripcionRepository.findTopCursosByNotaPromedio(topThree);
    }
}