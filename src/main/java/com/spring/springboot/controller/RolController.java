package com.spring.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Rol;
import com.spring.springboot.service.base.RolService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class RolController {
    @Autowired
    RolService rolService;

    @GetMapping("/rol")
    public List<Rol> getAllRol() {
        return rolService.getAllRol();
    }

    @PostMapping("/rol")
    public Rol createRol(@Valid @RequestBody Rol rol) {
        return rolService.createRol(rol);
    }

    @GetMapping("/rol/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable(value = "id") Long rolID)
            throws ResourceNotFoundException {
        return rolService.getRolById(rolID);
    }

    @PutMapping("/rol/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable(value = "id") Long rolID,
                                               @Valid @RequestBody Rol rolDetails) throws ResourceNotFoundException {
        return rolService.updateRol(rolID, rolDetails);
    }

    @DeleteMapping("/rol/{id}")
    public Map<String, Boolean> deleteRol(@PathVariable(value = "id") Long rolId) throws ResourceNotFoundException {
        return rolService.deleteRol(rolId);
    }
}
