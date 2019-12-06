package com.spring.springboot.dao.base.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.springboot.models.Usuario;
import com.spring.springboot.dao.base.UsuarioDAO;
import com.spring.springboot.exception.ResourceNotFoundException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuarioDAOImpl {
    @Autowired
    private UsuarioDAO UsuarioDAO;

    public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
        return UsuarioDAO.save(usuario);
    }

    public List<Usuario> getAllUsuario() {

        return UsuarioDAO.findAll();
    }

    public ResponseEntity<Usuario> getUsuarioById(
            @PathVariable(value = "id") Long usuarioId) throws ResourceNotFoundException {
        Usuario usuario = UsuarioDAO.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado: " + usuarioId));
        return ResponseEntity.ok().body(usuario);
    }


    public ResponseEntity<Usuario> updateUsuario(
            @PathVariable(value = "id") Long usuarioId,
            @Valid @RequestBody Usuario usuarioDetails) throws ResourceNotFoundException {
        Usuario usuario = UsuarioDAO.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado: " + usuarioId));


        usuario.setApellido(usuarioDetails.getApellido());
        usuario.setContraseña(usuarioDetails.getContraseña());
        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setEmail(usuarioDetails.getEmail());
        usuario.setIdRol(usuarioDetails.getIdRol());

        final Usuario updatedUsuario = UsuarioDAO.save(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    public Map<String, Boolean> deleteUsuario(
            @PathVariable(value = "id") Long usuarioId) throws ResourceNotFoundException {
        Usuario usuario = UsuarioDAO.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado: " + usuarioId));

        UsuarioDAO.delete(usuario);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
