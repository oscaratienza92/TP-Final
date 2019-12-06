package com.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Usuario;
import com.spring.springboot.service.base.UsuarioService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;

	@GetMapping("/usuario")
	public List<Usuario> getAllUsuario() {
		return usuarioService.getAllUsuario();
	}

	@PostMapping("/usuario")
	public Usuario createUsuario(@Valid @RequestBody Usuario usuario) {
		return usuarioService.createUsuario(usuario);
	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getUsuarioById(@PathVariable(value = "id") Long usuarioID)
			throws ResourceNotFoundException {
		return usuarioService.getUsuarioById(usuarioID);
	}

	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "id") Long usuarioID,
			@Valid @RequestBody Usuario usuarioDetails) throws ResourceNotFoundException {
		return usuarioService.updateUsuario(usuarioID, usuarioDetails);
	}

	@DeleteMapping("/usuario/{id}")
	public Map<String, Boolean> deleteUsuario(@PathVariable(value = "id") Long usuarioId)
			throws ResourceNotFoundException {
		return usuarioService.deleteUsuario(usuarioId);
	}
}
