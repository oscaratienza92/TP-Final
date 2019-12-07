package com.spring.springboot.service.base.impl;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.springboot.dao.base.impl.MateriaDAOImpl;
import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Materia;
import com.spring.springboot.service.base.MateriaService;

@Service
public class MateriaServiceImpl implements MateriaService {

	@Autowired
    MateriaDAOImpl materiaDAOImpl;
	
	@Override
    public Materia createMateria(@Valid @RequestBody Materia materia){
		return materiaDAOImpl.createMateria(materia);
	}

	@Override
	public List<Materia> getAllMaterias() {
		return materiaDAOImpl.getAllMaterias();		
	}
	
	@Override
	public ResponseEntity<Materia> getMateriaById(Long materiaID) throws ResourceNotFoundException {
		return materiaDAOImpl.getMateriaById(materiaID);
	}
	
	@Override
	public ResponseEntity<Materia> updateMateria(Long materiaID, Materia materiaDetails) throws ResourceNotFoundException {
		return materiaDAOImpl.updateMateria(materiaID, materiaDetails);
	}
	
	@Override
	public Map<String, Boolean> deleteMateria(Long materiaId) throws ResourceNotFoundException {
		return materiaDAOImpl.deleteMateria(materiaId);
	}


}
