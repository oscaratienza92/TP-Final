package com.spring.springboot.service.base.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.springboot.dao.base.impl.UsuarioDAOImpl;
import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Usuario;
import com.spring.springboot.service.base.UsuarioService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioServiceImple implements UsuarioService {
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
}
