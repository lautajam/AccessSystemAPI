package com.lautajam.AccessSystem.controller;

import com.lautajam.AccessSystem.dto.AreaDTO;
import com.lautajam.AccessSystem.dto.BuildingDTO;
import com.lautajam.AccessSystem.model.Area;
import com.lautajam.AccessSystem.model.Building;
import com.lautajam.AccessSystem.service.implement.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/building")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    /**
     * Creates a new building in the system using the provided data.
     *
     * @param building The Employee object containing the information of the building to be created.
     * @return ResponseEntity with the operation status:
     *         - HttpStatus.CREATED (201) if the building is successfully created.
     *         - HttpStatus.INTERNAL_SERVER_ERROR (500) if an error occurs during the operation.
     */
    @PostMapping("/create")
    public ResponseEntity<String> createBuilding(@RequestBody Building building) {
        try {
            buildingService.saveBuilding(building);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Returns all the building in the database.
     *
     * @return A ResponseEntity with the list of building if there are building in the database.
     *         - HttpStatus.OK (200) if there are building available.
     *         - HttpStatus.NO_CONTENT (204) if there are no building in the database.
     */
    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<List<BuildingDTO>> getAllBuildings(){
        List<Building> allBuildingList = buildingService.getAllBuildings();

        if (!allBuildingList.isEmpty()){
            List<BuildingDTO> allBuildingDTOList = buildingService.convertToBuildingDTOList(allBuildingList);
            return new ResponseEntity<>(allBuildingDTOList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    /**
     * Retrieves an building by its id.
     *
     * @param building_id The id of the building to be retrieved.
     * @return ResponseEntity with the building and the status of the operation:
     *         - HttpStatus.OK (200) if the building is successfully retrieved.
     *         - HttpStatus.NO_CONTENT (204) if no building is found.
     */
    @GetMapping("/get/{building_id}")
    @ResponseBody
    public ResponseEntity<BuildingDTO> getBuildingById(@PathVariable long building_id){
        Building buildingById = buildingService.getBuildingById(building_id);

        if(buildingById != null){
            BuildingDTO buildingDTOById = buildingService.convertToBuildingDTO(buildingById);
            return new ResponseEntity<>(buildingDTOById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    /**
     * Update a building in the system using the provided data.
     *
     * @param building The building object containing the information of the building to be updated.
     * @return ResponseEntity with the building and the status of the operation:
     *         - HttpStatus.OK (200) if the building is updated successfully.
     *         - HttpStatus.NOT_FOUND (404) if the building to be updated is not found.
     *         - HttpStatus.INTERNAL_SERVER_ERROR (500) if an error occurs during the operation.
     */
    @PutMapping("/update")
    public ResponseEntity<BuildingDTO> updateBuilding(@RequestBody Building building){
        try {
            buildingService.updateBuilding(building);
            Building buildingUpdated = buildingService.getBuildingById(building.getId());

            if (buildingUpdated != null) {
                BuildingDTO buildingDTO = buildingService.convertToBuildingDTO(buildingUpdated);
                return new ResponseEntity<>(buildingDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes a building by its id.
     *
     * @param building_id The id of the building to be deleted.
     * @return A ResponseEntity with the operation status:
     *         - HttpStatus.NOT_FOUND (404) if the building to be deleted is not found.
     *         - HttpStatus.NO_CONTENT (204) if the building is deleted successfully.
     *         - HttpStatus.INTERNAL_SERVER_ERROR (500) if an error occurs during the operation.
     */
    @DeleteMapping("/delete/{building_id}")
    public ResponseEntity<String> deleteBuilding(@PathVariable long building_id){
        try {
            if(buildingService.getBuildingById(building_id) == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else{
                buildingService.deleteBuildingById(building_id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
