package com.spring.springboot.dao.base;


import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.springboot.models.Curso;


public interface CursoDAO extends JpaRepository<Curso, Long>{

}
