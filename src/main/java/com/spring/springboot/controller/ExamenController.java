package com.spring.springboot.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Examen;
import com.spring.springboot.service.base.ExamenService;

@RestController
@RequestMapping("/app")
public class ExamenController {

	@Autowired
	ExamenService examenService;

	@GetMapping("/examen")
	public List<Examen> getAllExamen() {
		return examenService.getAllExamen();
	}

	@PostMapping("/examen")
	public Examen createExamen(@Valid @RequestBody Examen examen) {
		return examenService.createExamen(examen);
	}

	@GetMapping("/examen/{id}")
	public ResponseEntity<Examen> getUserById(@PathVariable(value = "id") Long examenID)
			throws ResourceNotFoundException {
		return examenService.getExamenById(examenID);
	}

	@PutMapping("/examen/{id}")
	public ResponseEntity<Examen> updateUser(@PathVariable(value = "id") Long examenID,
			@Valid @RequestBody Examen examenDetails) throws ResourceNotFoundException {
		return examenService.updateExamen(examenID, examenDetails);
	}

	@DeleteMapping("/examen/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long examenId) throws ResourceNotFoundException {
		return examenService.deleteExamen(examenId);
	}

}
