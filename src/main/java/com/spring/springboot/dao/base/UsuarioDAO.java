package com.spring.springboot.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.springboot.models.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
	
	public Usuario findByUsername(String usuario);
	
}
