package com.lautajam.AccessSystem.service.implement;

import com.lautajam.AccessSystem.model.Rol;
import com.lautajam.AccessSystem.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lautajam.AccessSystem.repository.IRolRepository;

import java.util.List;

@Service
public class RolService implements IRolService {

    /**
     * The rol repository to be injected. This repository provides access to the database.
     * This repository is used for tasks such as creating, updating, and retrieving rol
     * information from the database.
     */
    @Autowired
    private IRolRepository rolRepository;

    /**
     * Saves a rol to the database
     * @param rol The rol to be saved
     */
    @Override
    public void saveRol(Rol rol) {
        rolRepository.save(rol);
    }

    /**
     * Returns a list of all roles in the database.
     * @return A list of all roles in the database
     */
    @Override
    public List<Rol> getAllRols() {
        List<Rol> rolList = rolRepository.findAll();
        return rolList;
    }

    /**
     * Returns a rol with the given id.
     * @param rol_id The id of the rol to be returned
     * @return The rol with the given id or null if no rol with the given id exists
     */
    @Override
    public Rol getRolById(long rol_id) {
        Rol rolById = rolRepository.findById(rol_id).orElse(null);
        return rolById;
    }

    /**
     * Updates a rol with the give a rol.
     * @param rol The rol to be updated
     */
    @Override
    public void updateRol(Rol rol) {
        this.saveRol(rol);
    }

    /**
     * Deletes a rol with the given id.
     * @param rol_id The id of the rol to be deleted
     */
    @Override
    public void deleteRolById(long rol_id) {
        rolRepository.deleteById(rol_id);
    }
}
