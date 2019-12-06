package com.spring.springboot.service.base;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Curso;

public interface CursoService {

	
    public Curso createCurso(Curso curso);
    public List<Curso> getAllUsers();
    public ResponseEntity<Curso> getCursoById(Long cursoID) throws ResourceNotFoundException;
    public ResponseEntity<Curso> updateCurso(Long cursoID, Curso cursoDetails) throws ResourceNotFoundException;
    public Map<String, Boolean> deleteCurso(Long cursoId) throws ResourceNotFoundException;
    
    public void borrar(Curso Curso);
    public void borrar(int id);
    public void actualizar(Curso curso);
    public Curso getPorId(int id);
    public List<Curso> getPorNombre(String nombre);
    public List<Curso> getTodas();
	
	
}
