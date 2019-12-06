package com.spring.springboot.service.base;


import org.springframework.http.ResponseEntity;

import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Rol;

import java.util.List;
import java.util.Map;

public interface RolService {
    public Rol createRol(Rol rol);
    public List<Rol> getAllRol();
    public ResponseEntity<Rol> getRolById(Long rolID) throws ResourceNotFoundException;
    public ResponseEntity<Rol> updateRol(Long rolID, Rol rolDetails) throws ResourceNotFoundException;
    public Map<String, Boolean> deleteRol(Long rolId) throws ResourceNotFoundException;


}
