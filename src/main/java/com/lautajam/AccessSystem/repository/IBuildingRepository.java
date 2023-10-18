package com.lautajam.AccessSystem.repository;

import com.lautajam.AccessSystem.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBuildingRepository extends JpaRepository<Building, Long> {
}
