package com.spring.springboot.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springboot.models.Examen;

public interface ExamenDAO extends JpaRepository<Examen, Long> {
}
