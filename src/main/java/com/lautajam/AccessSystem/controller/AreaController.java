package com.lautajam.AccessSystem.controller;

import com.lautajam.AccessSystem.dto.AreaDTO;
import com.lautajam.AccessSystem.model.Area;
import com.lautajam.AccessSystem.model.Building;
import com.lautajam.AccessSystem.model.Rol;
import com.lautajam.AccessSystem.service.implement.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/area")
public class AreaController{

    /**
     * The area service to be injected. This service provides access to the database
     * for retrieving and managing area-related data.
     * This service is used for tasks such as creating, updating, and retrieving area
     * information from the database.
     */
    @Autowired
    private AreaService areaService;

    /**
     * Creates a new area in the database.
     *
     * @param area The Area object to be created.
     * @return A ResponseEntity with the operation status:
     *         - HttpStatus.CREATED (201) if the area is successfully created.
     *         - HttpStatus.INTERNAL_SERVER_ERROR (500) if an error occurs during the operation.
     */
    @PostMapping("/create")
    public ResponseEntity<String> createArea(@RequestBody Area area){
        try {
            areaService.saveArea(area);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Returns all the areas in the database.
     *
     * @return A ResponseEntity with the list of areas if there are areas in the database.
     *         - HttpStatus.OK (200) if there are areas available.
     *         - HttpStatus.NO_CONTENT (204) if there are no areas in the database.
     */
    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<List<AreaDTO>> getAllAreas(){
        List<Area> allAreaList = areaService.getAllAreas();
        if (!allAreaList.isEmpty()){
            List<AreaDTO> areaDTOList = areaService.convertToAreaDTOList(allAreaList);
            return new ResponseEntity<>(areaDTOList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    /**
     * Returns a area by its id if it exists in the database.
     *
     * @param area_id The id of the area to be returned.
     * @return A ResponseEntity with the area if it exists in the database.
     *         - HttpStatus.OK (200) if the area is found.
     *         - HttpStatus.NOT_FOUND (404) if the area does not exist.
     */
    @GetMapping("/get/{area_id}")
    public ResponseEntity<AreaDTO> getAreaById(@PathVariable long area_id){
        Area areaById = areaService.getAreaById(area_id);
        if(areaById != null){
            AreaDTO areaDTObyId = areaService.convertToAreaDTO(areaById);
            return new ResponseEntity<>(areaDTObyId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Updates an existing area.
     *
     * @param area The area to be updated.
     * @return A ResponseEntity with the operation status:
     *         - HttpStatus.OK (200) if the area is updated successfully.
     *         - HttpStatus.NOT_FOUND (404) if the area to be updated is not found.
     *         - HttpStatus.INTERNAL_SERVER_ERROR (500) if an error occurs during the operation.
     */
    @PutMapping("/update")
    public ResponseEntity<AreaDTO> updateArea(@RequestBody Area area){
        try {
            areaService.updateArea(area);
            Area areaUpdated = areaService.getAreaById(area.getId());

            if (areaUpdated != null) {
                AreaDTO areaDTO = areaService.convertToAreaDTO(areaUpdated);
                return new ResponseEntity<>(areaDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes a area by its id.
     *
     * @param area_id The id of the area to be deleted.
     * @return A ResponseEntity with the operation status:
     *         - HttpStatus.NOT_FOUND (404) if the area to be deleted is not found.
     *         - HttpStatus.NO_CONTENT (204) if the area is deleted successfully.
     *         - HttpStatus.INTERNAL_SERVER_ERROR (500) if an error occurs during the operation.
     */
    @DeleteMapping("/delete/{area_id}")
    public ResponseEntity<String> deleteArea(@PathVariable long area_id){
        try {
            if (areaService.getAreaById(area_id) == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else {
                areaService.deleteAreaById(area_id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
