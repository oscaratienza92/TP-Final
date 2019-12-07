package com.spring.springboot.service.base;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Curso;

public interface CursoService {

	
    public Curso createCurso(Curso curso);
    public List<Curso> getAllCursos();
    public ResponseEntity<Curso> getCursoById(Long cursoID) throws ResourceNotFoundException;
    public ResponseEntity<Curso> updateCurso(Long cursoID, Curso cursoDetails) throws ResourceNotFoundException;
    public Map<String, Boolean> deleteCurso(Long cursoId) throws ResourceNotFoundException;

	
	
}
