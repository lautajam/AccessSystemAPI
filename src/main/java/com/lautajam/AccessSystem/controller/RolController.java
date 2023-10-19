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
     * @param rol The rol to be created.
     * @return A CREATED response with the created rol if the rol was created successfully.
     *         Otherwise, it returns an INTERNAL_SERVER_ERROR response.
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
     * @return An OK response with the list of roles if there are roles in the database.
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
     * @return An OK response with the rol if it exists in the database.
     *         Otherwise, it returns a NOT_FOUND response.
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
     * @return An OK response if the role was updated successfully.
     *         Otherwise, it returns an INTERNAL_SERVER_ERROR response.
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
     * @return If the rol not exists, it returns a NOT_FOUND response.
     *          A NO_CONTENT response if the rol wass deleted successfully.
     *          Otherwise, it returns an INTERNAL_SERVER_ERROR response.
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
