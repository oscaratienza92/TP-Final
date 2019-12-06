package com.spring.springboot.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springboot.models.Rol;

public interface RolDAO extends JpaRepository<Rol, Long> {
}
