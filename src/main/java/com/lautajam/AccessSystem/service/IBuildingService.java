package com.lautajam.AccessSystem.service;

import com.lautajam.AccessSystem.model.Building;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBuildingService{


    /**
     * Saves a building to the database
     * @param building The building to be saved
     */
    public void saveBuilding(Building building);

    /**
     * Returns a list of all buildings in the database.
     * @return A list of all buildings in the database
     */
    public List<Building> getAllBuildings();

    /**
     * Returns a building with the given id.
     * @param building_id The id of the building to be returned
     * @return The building with the given id or null if no building with the given id exists
     */
    public Building getBuildingById(long building_id);

    /**
     * Updates a building with the give a building.
     * @param building The building to be updated
     */
    public void updateBuilding(Building building);

    /**
     * Deletes a building with the given id.
     * @param building_id The id of the building to be deleted
     */
    public void deleteBuildingById(long building_id);

}
