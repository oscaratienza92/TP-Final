package com.spring.springboot.dao.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.springboot.dao.base.CursoDAO;
import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Curso;

public class CursoDAOImpl {

	@Autowired
	private CursoDAO cursoDAO;
	
	public Curso createCurso(@Valid @RequestBody Curso curso) {
		return cursoDAO.save(curso);
	}
	
	public List<Curso> getAllUsers() {
		return cursoDAO.findAll();
	}
	
	public ResponseEntity<Curso> getCursoById(
			@PathVariable(value = "id") Long cursoId) throws ResourceNotFoundException {
		Curso curso = cursoDAO.findById(cursoId)
        .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado: " + cursoId));
		return ResponseEntity.ok().body(curso);
	}
	
	
	public ResponseEntity<Curso> updateCurso(
			@PathVariable(value = "id") Long cursoId,
			@Valid @RequestBody Curso cursoDetails) throws ResourceNotFoundException {
		Curso curso = cursoDAO.findById(cursoId)
		        .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado :: " + cursoId));
		
		curso.setNombre(cursoDetails.getNombre());
		final Curso updatedUser = cursoDAO.save(curso);
		return ResponseEntity.ok(updatedUser);
	}
	
	public Map<String, Boolean> deleteCurso(
			@PathVariable(value = "id") Long cursoId) throws ResourceNotFoundException {
		Curso curso = cursoDAO.findById(cursoId)
		        .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado :: " + cursoId));

		cursoDAO.delete(curso);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
