package com.lautajam.AccessSystem.service.implement;

import com.lautajam.AccessSystem.dto.BuildingDTO;
import com.lautajam.AccessSystem.dto.BuildingDTO;
import com.lautajam.AccessSystem.model.Building;
import com.lautajam.AccessSystem.model.Building;
import com.lautajam.AccessSystem.repository.IBuildingRepository;
import com.lautajam.AccessSystem.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingService implements IBuildingService {

    /**
     * The building repository to be injected. This repository provides access to the database.
     * This repository is used for tasks such as creating, updating, and retrieving building
     * information from the database.
     */
    @Autowired
    private IBuildingRepository buildingRepository;

    /**
     * Saves a building to the database
     * @param building The building to be saved
     */
    @Override
    public void saveBuilding(Building building) {
        buildingRepository.save(building);
    }

    /**
     * Returns a list of all buildings in the database.
     * @return A list of all buildings in the database
     */
    @Override
    public List<Building> getAllBuildings() {
        List<Building> buildingList = buildingRepository.findAll();
        return buildingList;
    }

    /**
     * Returns a building with the given id.
     * @param building_id The id of the building to be returned
     * @return The building with the given id or null if no building with the given id exists
     */
    @Override
    public Building getBuildingById(long building_id) {
        Building buildingById = buildingRepository.findById(building_id).orElse(null);
        return buildingById;
    }

    /**
     * Updates a building with the give a building.
     * @param building The building to be updated
     */
    @Override
    public void updateBuilding(Building building) {
        this.saveBuilding(building);
    }

    /**
     * Deletes a building with the given id.
     * @param building_id The id of the building to be deleted
     */
    @Override
    public void deleteBuildingById(long building_id) {
        buildingRepository.deleteById(building_id);
    }

    /**
     * Convert Building list to a BuildingDTO list with IDs and names of roles and buildings.
     *
     * @param buildingList a list of Building objects.
     * @return a list of BuildingDTO objects.
     */
    public List<BuildingDTO> convertToBuildingDTOList(List<Building> buildingList) {
        return buildingList.stream()
                .map(building -> new BuildingDTO(
                        building.getId(),
                        building.getName(),
                        building.getAddress(),
                        building.getRoles().stream()
                                .map(rol -> "Id: " + rol.getId() + " | Name: " + rol.getName())
                                .collect(Collectors.toList()),
                        building.getAreas().stream()
                                .map(area -> "Id: " + area.getId() + " | Name: " + area.getName())
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    /**
     * Convert Building to a BuildingDTO with IDs and names of roles and buildings.
     *
     * @param building a Building object.
     * @return a BuildingDTO object.
     */
    public BuildingDTO convertToBuildingDTO(Building building) {
        return new BuildingDTO(
                building.getId(),
                building.getName(),
                building.getAddress(),
                building.getRoles().stream()
                        .map(rol -> "Id: " + rol.getId() + " | Name: " + rol.getName())
                        .collect(Collectors.toList()),
                building.getAreas().stream()
                        .map(area -> "Id: " + area.getId() + " | Name: " + area.getName())
                        .collect(Collectors.toList())
        );
    }
}
