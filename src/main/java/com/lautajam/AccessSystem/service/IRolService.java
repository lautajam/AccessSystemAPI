package com.lautajam.AccessSystem.service;

import com.lautajam.AccessSystem.model.Rol;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRolService {

    /**
     * Saves a rol to the database
     * @param rol The rol to be saved
     */
    public void saveRol(Rol rol);

    /**
     * Returns a list of all roles in the database.
     * @return A list of all roles in the database
     */
    public List<Rol> getAllRols();

    /**
     * Returns a rol with the given id.
     * @param rol_id The id of the rol to be returned
     * @return The rol with the given id or null if no rol with the given id exists
     */
    public Rol getRolById(long rol_id);

    /**
     * Updates a rol with the give a rol.
     * @param rol The rol to be updated
     */
    public void updateRol(Rol rol);

    /**
     * Deletes a rol with the given id.
     * @param rol_id The id of the rol to be deleted
     */
    public void deleteRolById(long rol_id);

}
