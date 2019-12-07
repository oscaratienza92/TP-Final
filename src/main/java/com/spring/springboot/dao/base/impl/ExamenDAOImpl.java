package com.spring.springboot.dao.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.springboot.dao.base.ExamenDAO;
import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Examen;

public class ExamenDAOImpl {

	@Autowired
	private ExamenDAO examenDAO;
	
	public Examen createExamen(@Valid @RequestBody Examen examen) {
		return examenDAO.save(examen);
	}
	
	public List<Examen> getAllExamen() {
		return examenDAO.findAll();
	}
	
	public ResponseEntity<Examen> getExamenById(
			@PathVariable(value = "id") Long examenId) throws ResourceNotFoundException {
		Examen examen = examenDAO.findById(examenId)
        .orElseThrow(() -> new ResourceNotFoundException("Examen no encontrado: " + examenId));
		return ResponseEntity.ok().body(examen);
	}
	
	
	public ResponseEntity<Examen> updateExamen(
			@PathVariable(value = "id") Long examenId,
			@Valid @RequestBody Examen examenDetails) throws ResourceNotFoundException {
		Examen examen = examenDAO.findById(examenId)
		        .orElseThrow(() -> new ResourceNotFoundException("Examen no encontrado :: " + examenId));
		
		examen.setNota(examenDetails.getNota());
		examen.setMaterias(examenDetails.getMaterias());
		examen.setUsuario(examenDetails.getUsuario());
		
		final Examen updatedUser = examenDAO.save(examen);
		return ResponseEntity.ok(updatedUser);
	}
	
	public Map<String, Boolean> deleteExamen(
			@PathVariable(value = "id") Long examenId) throws ResourceNotFoundException {
		Examen examen = examenDAO.findById(examenId)
		        .orElseThrow(() -> new ResourceNotFoundException("Examen no encontrado :: " + examenId));

		examenDAO.delete(examen);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
