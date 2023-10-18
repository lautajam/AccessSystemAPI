package com.lautajam.AccessSystem.repository;

import com.lautajam.AccessSystem.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAreaRepository extends JpaRepository<Area, Long> {
}