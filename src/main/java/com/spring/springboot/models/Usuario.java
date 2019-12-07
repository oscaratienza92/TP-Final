package com.spring.springboot.models;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@ManyToMany
	@JoinColumn(name = "usuario_rol")
	private Set<Rol>  idRol;
	
	@Column(name = "username")
	private String username;

	@NotNull(message = "no puede estar vacio")
	@Column(name = "nombre")
	private String nombre;

	@NotNull(message = "no puede estar vacio")
	@Column(name = "apellido")
	private String apellido;

	@Column(name = "email")
	private String email;

	@NotNull(message = "no puede estar vacio")
	@Column(name = "password")
	private String password;
	
	@ManyToMany
	@JoinColumn(name="usuario_id")
	private Set<Materia> idMateria;
	
	private Boolean enabled;
	
	public Usuario() {
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Set<Rol> getIdRol() {
		return idRol;
	}

	public void setIdRol(Set<Rol> idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return password;
	}

	public void setContraseña(String contraseña) {
		this.password = contraseña;
	}
	
	public Set<Materia> getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Set<Materia> idMateria) {
		this.idMateria = idMateria;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
