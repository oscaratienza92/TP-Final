package com.spring.springboot.service.base;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Usuario;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Map;

public interface UsuarioService {

    public Usuario createUsuario(Usuario usuario);
    public List<Usuario> getAllUsuario();
    public ResponseEntity<Usuario> getUsuarioById(Long usuarioID) throws ResourceNotFoundException;
    public ResponseEntity<Usuario> updateUsuario(Long usuarioID, Usuario usuarioDetails) throws ResourceNotFoundException;
    public Map<String, Boolean> deleteUsuario(Long usuarioId) throws ResourceNotFoundException;
    
    public Usuario findByUsuario(String usuario);
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    
}
