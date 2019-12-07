package com.spring.springboot.service.base.impl;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.springboot.dao.base.impl.ExamenDAOImpl;
import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Examen;
import com.spring.springboot.service.base.ExamenService;

@Service
public class ExamenServiceImpl implements ExamenService {

	@Autowired
    ExamenDAOImpl examenDAOImpl;
	
	@Override
    public Examen createExamen(@Valid @RequestBody Examen examen){
		return examenDAOImpl.createExamen(examen);
	}

	@Override
	public List<Examen> getAllExamen() {
		return examenDAOImpl.getAllExamen();		
	}
	
	@Override
	public ResponseEntity<Examen> getExamenById(Long examenID) throws ResourceNotFoundException {
		return examenDAOImpl.getExamenById(examenID);
	}
	
	@Override
	public ResponseEntity<Examen> updateExamen(Long examenID, Examen examenDetails) throws ResourceNotFoundException {
		return examenDAOImpl.updateExamen(examenID, examenDetails);
	}
	
	@Override
	public Map<String, Boolean> deleteExamen(Long examenId) throws ResourceNotFoundException {
		return examenDAOImpl.deleteExamen(examenId);
	}


}
