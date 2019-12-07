package com.spring.springboot.service.base.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.springboot.dao.base.impl.UsuarioDAOImpl;
import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Usuario;
import com.spring.springboot.service.base.UsuarioService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImple implements UsuarioService, UserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
    @Autowired
    UsuarioDAOImpl usuarioDAOImpl;

    @Override
    public Usuario createUsuario(@Valid @RequestBody Usuario usuario){
        return usuarioDAOImpl.createUsuario(usuario);
    }

    @Override
    public List<Usuario> getAllUsuario() {
        return usuarioDAOImpl.getAllUsuario();
    }

    @Override
    public ResponseEntity<Usuario> getUsuarioById(Long usuarioID) throws ResourceNotFoundException {
        return usuarioDAOImpl.getUsuarioById(usuarioID);
    }

    @Override
    public ResponseEntity<Usuario> updateUsuario(Long usuarioID, Usuario usuarioDetails) throws ResourceNotFoundException {
        return usuarioDAOImpl.updateUsuario(usuarioID, usuarioDetails);
    }

    @Override
    public Map<String, Boolean> deleteUsuario(Long usuarioId) throws ResourceNotFoundException {
        return usuarioDAOImpl.deleteUsuario(usuarioId);
    }
    
	@Override
	@Transactional(readOnly=true)
	public Usuario findByUsuario(String usuario) {
		return usuarioDAOImpl.findByUsuario(usuario);
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioDAOImpl.findByUsuario(username);
		
		if(usuario == null) {
			logger.error("Error en el login: no existe el usuario '"+username+"' en el sistema!");
			throw new UsernameNotFoundException("Error en el login: no existe el usuario '"+username+"' en el sistema!");
		}
		
		List<GrantedAuthority> authorities = usuario.getIdRol()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}
	
}
