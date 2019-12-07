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
import com.spring.springboot.models.Curso;
import com.spring.springboot.service.base.CursoService;

@RestController
@RequestMapping("/app")
public class CursoController {

	@Autowired
	CursoService cursoService;

	@GetMapping("/curso")
	public List<Curso> getAllCursos() {
		return cursoService.getAllCursos();
	}

	@PostMapping("/curso")
	public Curso createCurso(@Valid @RequestBody Curso curso) {
		return cursoService.createCurso(curso);
	}

	@GetMapping("/curso/{id}")
	public ResponseEntity<Curso> getCursoById(@PathVariable(value = "id") Long cursoID)
			throws ResourceNotFoundException {
		return cursoService.getCursoById(cursoID);
	}

	@PutMapping("/curso/{id}")
	public ResponseEntity<Curso> updateCurso(@PathVariable(value = "id") Long cursoID,
			@Valid @RequestBody Curso cursoDetails) throws ResourceNotFoundException {
		return cursoService.updateCurso(cursoID, cursoDetails);
	}

	@DeleteMapping("/curso/{id}")
	public Map<String, Boolean> deleteCurso(@PathVariable(value = "id") Long cursoId) throws ResourceNotFoundException {
		return cursoService.deleteCurso(cursoId);
	}

}
