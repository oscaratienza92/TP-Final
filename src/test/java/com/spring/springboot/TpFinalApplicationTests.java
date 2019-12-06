package com.spring.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.service.base.CursoService;

@SpringBootTest
class TpFinalApplicationTests {
	@Autowired
	CursoService cursoService;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetCurso() {
		assert (cursoService.getAllUsers()) != null;
	}
	
	@Test
	public void testGetCursoById() throws ResourceNotFoundException {
		assert (cursoService.getCursoById(1L)) != null;
	}
}
