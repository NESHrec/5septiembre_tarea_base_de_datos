package com.example.gestionacademica.gestion_academica.controller;

import com.example.gestionacademica.gestion_academica.dto.CicloEstudianteCountDTO;
import com.example.gestionacademica.gestion_academica.dto.CursoNotaPromedioDTO;
import com.example.gestionacademica.gestion_academica.dto.ProfesorCursoCountDTO;
import com.example.gestionacademica.gestion_academica.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    @Autowired
    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping("/profesor-cursos")
    public ResponseEntity<List<ProfesorCursoCountDTO>> getReporteProfesorCursos() {
        List<ProfesorCursoCountDTO> reporte = reporteService.getProfesorCursoCounts();
        return ResponseEntity.ok(reporte);
    }

    @GetMapping("/curso-promedio")
    public ResponseEntity<List<CursoNotaPromedioDTO>> getReporteCursoPromedio() {
        List<CursoNotaPromedioDTO> reporte = reporteService.getCursoNotaPromedio();
        return ResponseEntity.ok(reporte);
    }

    @GetMapping("/estudiantes-ciclo")
    public ResponseEntity<List<CicloEstudianteCountDTO>> getReporteEstudiantesCiclo() {
        List<CicloEstudianteCountDTO> reporte = reporteService.getEstudiantesPorCiclo();
        return ResponseEntity.ok(reporte);
    }

    @GetMapping("/top-cursos")
    public ResponseEntity<List<CursoNotaPromedioDTO>> getReporteTopCursos() {
        List<CursoNotaPromedioDTO> reporte = reporteService.getTopCursosPorNota();
        return ResponseEntity.ok(reporte);
    }
}