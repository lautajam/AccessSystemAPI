package com.lautajam.AccessSystem.service.implement;

import com.lautajam.AccessSystem.dto.AreaDTO;
import com.lautajam.AccessSystem.model.Area;
import com.lautajam.AccessSystem.repository.IAreaRepository;
import com.lautajam.AccessSystem.service.IAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AreaService implements IAreaService {

    @Autowired
    IAreaRepository areaRepository;

    /**
     * Saves a area to the database
     * @param area The area to be saved
     */
    @Override
    public void saveArea(Area area) {
        areaRepository.save(area);
    }

    /**
     * Returns a list of all areas in the database.
     * @return A list of all areas in the database
     */
    @Override
    public List<Area> getAllAreas() {
        List<Area> areaList = areaRepository.findAll();
        return areaList;
    }

    /**
     * Returns a area with the given id.
     * @param area_id The id of the area to be returned
     * @return The area with the given id or null if no area with the given id exists
     */
    @Override
    public Area getAreaById(long area_id) {
        Area areaById = areaRepository.findById(area_id).orElse(null);
        return areaById;
    }

    /**
     * Updates a area with the give a area.
     * @param area The area to be updated
     */
    @Override
    public void updateArea(Area area) {
        this.saveArea(area);
    }

    /**
     * Deletes a area with the given id.
     * @param area_id The id of the area to be deleted
     */
    @Override
    public void deleteAreaById(long area_id) {
        areaRepository.deleteById(area_id);
    }

    /**
     * Convert Area list to a AreaDTO list with IDs and names of roles and buildings.
     *
     * @param areaList a list of Area objects.
     * @return a list of AreaDTO objects.
     */
    public List<AreaDTO> convertToAreaDTOList(List<Area> areaList) {
        return areaList.stream()
                .map(area -> new AreaDTO(
                        area.getId(),
                        area.getName(),
                        area.getTelephone(),
                        area.getEmail(),
                        area.getDescription(),
                        area.getRoles().stream()
                                .map(rol -> "Id: " + rol.getId() + " | Name: " + rol.getName())
                                .collect(Collectors.toList()),
                        area.getBuildings().stream()
                                .map(building -> "Id: " + building.getId() + " | Name: " + building.getName())
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    /**
     * Convert Area to a AreaDTO with IDs and names of roles and buildings.
     *
     * @param area a Area object.
     * @return a AreaDTO object.
     */
    public AreaDTO convertToAreaDTO(Area area) {
        return new AreaDTO(
                area.getId(),
                area.getName(),
                area.getTelephone(),
                area.getEmail(),
                area.getDescription(),
                area.getRoles().stream()
                        .map(rol -> "Id: " + rol.getId() + " | Name: " + rol.getName())
                        .collect(Collectors.toList()),
                area.getBuildings().stream()
                        .map(building -> "Id: " + building.getId() + " | Name: " + building.getName())
                        .collect(Collectors.toList())
        );
    }
}
