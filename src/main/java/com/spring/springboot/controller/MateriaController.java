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
import com.spring.springboot.models.Materia;
import com.spring.springboot.service.base.MateriaService;

@RestController
@RequestMapping("/app")
public class MateriaController {

	@Autowired
	MateriaService materiaService;

	@GetMapping("/materia")
	public List<Materia> getAllMaterias() {
		return materiaService.getAllMaterias();
	}

	@PostMapping("/materia")
	public Materia createMateria(@Valid @RequestBody Materia materia) {
		return materiaService.createMateria(materia);
	}

	@GetMapping("/materia/{id}")
	public ResponseEntity<Materia> getUserById(@PathVariable(value = "id") Long materiaID)
			throws ResourceNotFoundException {
		return materiaService.getMateriaById(materiaID);
	}

	@PutMapping("/materia/{id}")
	public ResponseEntity<Materia> updateUser(@PathVariable(value = "id") Long materiaID,
			@Valid @RequestBody Materia materiaDetails) throws ResourceNotFoundException {
		return materiaService.updateMateria(materiaID, materiaDetails);
	}

	@DeleteMapping("/materia/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long materiaId) throws ResourceNotFoundException {
		return materiaService.deleteMateria(materiaId);
	}

}
