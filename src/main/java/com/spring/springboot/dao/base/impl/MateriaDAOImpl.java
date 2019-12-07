package com.spring.springboot.dao.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.springboot.dao.base.MateriaDAO;
import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Materia;

public class MateriaDAOImpl {

	@Autowired
	private MateriaDAO materiaDAO;
	
	public Materia createMateria(@Valid @RequestBody Materia materia) {
		return materiaDAO.save(materia);
	}
	
	public List<Materia> getAllMaterias() {
		return materiaDAO.findAll();
	}
	
	public ResponseEntity<Materia> getMateriaById(
			@PathVariable(value = "id") Long materiaId) throws ResourceNotFoundException {
		Materia materia = materiaDAO.findById(materiaId)
        .orElseThrow(() -> new ResourceNotFoundException("Materia no encontrado: " + materiaId));
		return ResponseEntity.ok().body(materia);
	}
	
	
	public ResponseEntity<Materia> updateMateria(
			@PathVariable(value = "id") Long materiaId,
			@Valid @RequestBody Materia materiaDetails) throws ResourceNotFoundException {
		Materia materia = materiaDAO.findById(materiaId)
		        .orElseThrow(() -> new ResourceNotFoundException("Materia no encontrado :: " + materiaId));
		
		materia.setNombre(materiaDetails.getNombre());
		final Materia updatedUser = materiaDAO.save(materia);
		return ResponseEntity.ok(updatedUser);
	}
	
	public Map<String, Boolean> deleteMateria(
			@PathVariable(value = "id") Long materiaId) throws ResourceNotFoundException {
		Materia materia = materiaDAO.findById(materiaId)
		        .orElseThrow(() -> new ResourceNotFoundException("Materia no encontrado :: " + materiaId));

		materiaDAO.delete(materia);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
