package com.spring.springboot.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springboot.models.Materia;

public interface MateriaDAO extends JpaRepository<Materia, Long> {
}
