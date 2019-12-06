package com.spring.springboot.dao.base.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.springboot.models.Rol;
import com.spring.springboot.dao.base.RolDAO;
import com.spring.springboot.exception.ResourceNotFoundException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RolDAOImpl {
    @Autowired
    private RolDAO RolDAO;

    public Rol createRol(@Valid @RequestBody Rol rol) {
        return RolDAO.save(rol);
    }

    public List<Rol> getAllRol() {

        return RolDAO.findAll();
    }

    public ResponseEntity<Rol> getRolById(
            @PathVariable(value = "id") Long rolId) throws ResourceNotFoundException {
        Rol rol = RolDAO.findById(rolId)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado: " + rolId));
        return ResponseEntity.ok().body(rol);
    }


    public ResponseEntity<Rol> updateRol(
            @PathVariable(value = "id") Long rolId,
            @Valid @RequestBody Rol rolDetails) throws ResourceNotFoundException {
        Rol rol = RolDAO.findById(rolId)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado: " + rolId));


        rol.setNombre(rolDetails.getNombre());
        rol.setDescripcion(rolDetails.getDescripcion());

        final Rol updatedRol = RolDAO.save(rol);
        return ResponseEntity.ok(updatedRol);
    }

    public Map<String, Boolean> deleteRol(
            @PathVariable(value = "id") Long rolId) throws ResourceNotFoundException {
        Rol rol = RolDAO.findById(rolId)
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado: " + rolId));

        RolDAO.delete(rol);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
