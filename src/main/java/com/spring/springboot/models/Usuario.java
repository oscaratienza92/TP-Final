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

	@OneToOne
	@JoinColumn(name = "rol")
	private Rol idRol;

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
	
	public Usuario() {
	}

	public Usuario(Long idUsuario, Rol idRol, @NotNull(message = "no puede estar vacio") String nombre,
			@NotNull(message = "no puede estar vacio") String apellido, String email,
			@NotNull(message = "no puede estar vacio") String contraseña) {
		this.idUsuario = idUsuario;
		this.idRol = idRol;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = contraseña;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Rol getIdRol() {
		return idRol;
	}

	public void setIdRol(Rol idRol) {
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

}
