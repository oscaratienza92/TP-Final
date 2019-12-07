package com.spring.springboot.service.base;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Examen;

public interface ExamenService {

	
    public Examen createExamen(Examen examen);
    public List<Examen> getAllExamen();
    public ResponseEntity<Examen> getExamenById(Long examenID) throws ResourceNotFoundException;
    public ResponseEntity<Examen> updateExamen(Long examenID, Examen examenDetails) throws ResourceNotFoundException;
    public Map<String, Boolean> deleteExamen(Long examenId) throws ResourceNotFoundException;

	
	
}
