package com.spring.springboot.service.base.impl;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.springboot.dao.base.impl.CursoDAOImpl;
import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Curso;
import com.spring.springboot.service.base.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
    CursoDAOImpl cursoDAOImpl;
	
	@Override
    public Curso createCurso(@Valid @RequestBody Curso curso){
		return cursoDAOImpl.createCurso(curso);
	}

	@Override
	public List<Curso> getAllCursos() {
		return cursoDAOImpl.getAllCursos();		
	}
	
	@Override
	public ResponseEntity<Curso> getCursoById(Long cursoID) throws ResourceNotFoundException {
		return cursoDAOImpl.getCursoById(cursoID);
	}
	
	@Override
	public ResponseEntity<Curso> updateCurso(Long cursoID, Curso cursoDetails) throws ResourceNotFoundException {
		return cursoDAOImpl.updateCurso(cursoID, cursoDetails);
	}
	
	@Override
	public Map<String, Boolean> deleteCurso(Long cursoId) throws ResourceNotFoundException {
		return cursoDAOImpl.deleteCurso(cursoId);
	}


}
