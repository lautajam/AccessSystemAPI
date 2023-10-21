package com.lautajam.AccessSystem.controller;

import com.lautajam.AccessSystem.model.Rol;
import com.lautajam.AccessSystem.service.implement.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rol")
public class RolController {

    /**
     * The rol service to be injected. This service provides access to the database
     * for retrieving and managing rol-related data.
     * This service is used for tasks such as creating, updating, and retrieving rol
     * information from the database.
     */
    @Autowired
    private RolService rolService;

    /**
     * Creates a new rol in the database.
     *
     * @param rol The Rol object to be created.
     * @return A ResponseEntity with the operation status:
     *         - HttpStatus.CREATED (201) if the rol is successfully created.
     *         - HttpStatus.INTERNAL_SERVER_ERROR (500) if an error occurs during the operation.
     */
    @PostMapping("/createRol")
    public ResponseEntity<String> createRol(@RequestBody Rol rol){
        try {
            rolService.saveRol(rol);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Returns all the roles in the database.
     *
     * @return A ResponseEntity with the list of roles if there are roles in the database.
     *         - HttpStatus.OK (200) if there are roles available.
     *         - HttpStatus.NO_CONTENT (204) if there are no roles in the database.
     */
    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<List<Rol>> getAllRoles(){

        List<Rol> allRolList = rolService.getAllRols();
        if (!allRolList.isEmpty()){
            return new ResponseEntity<>(allRolList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    /**
     * Returns a rol by its id if it exists in the database.
     *
     * @param rol_id The id of the rol to be returned.
     * @return A ResponseEntity with the rol if it exists in the database.
     *         - HttpStatus.OK (200) if the rol is found.
     *         - HttpStatus.NOT_FOUND (404) if the rol does not exist.
     */
    @GetMapping("/getRolById/{rol_id}")
    public ResponseEntity<Rol> getRolById(@PathVariable long rol_id){
        Rol rolById = rolService.getRolById(rol_id);
        if(rolById != null){
            return new ResponseEntity<>(rolById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Updates an existing role.
     *
     * @param rol The role to be updated.
     * @return A ResponseEntity with the operation status:
     *         - HttpStatus.OK (200) if the role is updated successfully.
     *         - HttpStatus.NOT_FOUND (404) if the role to be updated is not found.
     *         - HttpStatus.INTERNAL_SERVER_ERROR (500) if an error occurs during the operation.
     */
    @PutMapping("/updateRol")
    public ResponseEntity<Rol> updateRol(@RequestBody Rol rol){
        try {
            rolService.updateRol(rol);
            Rol rolUpdated = rolService.getRolById(rol.getId());

            if (rolUpdated != null) {
                return new ResponseEntity<>(rolUpdated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes a rol by its id.
     *
     * @param rol_id The id of the rol to be deleted.
     * @return A ResponseEntity with the operation status:
     *         - HttpStatus.NOT_FOUND (404) if the rol to be deleted is not found.
     *         - HttpStatus.NO_CONTENT (204) if the rol is deleted successfully.
     *         - HttpStatus.INTERNAL_SERVER_ERROR (500) if an error occurs during the operation.
     */
    @DeleteMapping("/deleteRol/{rol_id}")
    public ResponseEntity<String> deleteRol(@PathVariable long rol_id){
        try {
            if (rolService.getRolById(rol_id) == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else {
                rolService.deleteRolById(rol_id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
