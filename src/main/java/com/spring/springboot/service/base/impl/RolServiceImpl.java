package com.spring.springboot.service.base.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.springboot.dao.base.impl.RolDAOImpl;
import com.spring.springboot.exception.ResourceNotFoundException;
import com.spring.springboot.models.Rol;
import com.spring.springboot.service.base.RolService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Service
public class RolServiceImpl implements RolService {
    @Autowired
    RolDAOImpl rolDAOImpl;

    @Override
    public Rol createRol(@Valid @RequestBody Rol rol){
        return rolDAOImpl.createRol(rol);
    }

    @Override
    public List<Rol> getAllRol() {
        return rolDAOImpl.getAllRol();
    }

    @Override
    public ResponseEntity<Rol> getRolById(Long rolID) throws ResourceNotFoundException {
        return rolDAOImpl.getRolById(rolID);
    }

    @Override
    public ResponseEntity<Rol> updateRol(Long rolID, Rol rolDetails) throws ResourceNotFoundException {
        return rolDAOImpl.updateRol(rolID, rolDetails);
    }

    @Override
    public Map<String, Boolean> deleteRol(Long rolId) throws ResourceNotFoundException {
        return rolDAOImpl.deleteRol(rolId);
    }

}
