package com.spring.springboot.service.base;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Materia;

public interface MateriaService {

	
    public Materia createMateria(Materia materia);
    public List<Materia> getAllMaterias();
    public ResponseEntity<Materia> getMateriaById(Long materiaID) throws ResourceNotFoundException;
    public ResponseEntity<Materia> updateMateria(Long materiaID, Materia materiaDetails) throws ResourceNotFoundException;
    public Map<String, Boolean> deleteMateria(Long materiaId) throws ResourceNotFoundException;

	
	
}
