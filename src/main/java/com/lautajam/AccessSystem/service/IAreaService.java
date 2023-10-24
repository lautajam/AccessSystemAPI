package com.lautajam.AccessSystem.service;

import com.lautajam.AccessSystem.model.Area;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAreaService {

    /**
     * Saves a area to the database
     * @param area The area to be saved
     */
    public void saveArea(Area area);

    /**
     * Returns a list of all areas in the database.
     * @return A list of all areas in the database
     */
    public List<Area> getAllAreas();

    /**
     * Returns a area with the given id.
     * @param area_id The id of the area to be returned
     * @return The area with the given id or null if no area with the given id exists
     */
    public Area getAreaById(long area_id);

    /**
     * Updates a area with the give a area.
     * @param area The area to be updated
     */
    public void updateArea(Area area);

    /**
     * Deletes a area with the given id.
     * @param area_id The id of the area to be deleted
     */
    public void deleteAreaById(long area_id);
    
    
}
