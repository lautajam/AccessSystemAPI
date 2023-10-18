package com.lautajam.AccessSystem.repository;

import com.lautajam.AccessSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}
