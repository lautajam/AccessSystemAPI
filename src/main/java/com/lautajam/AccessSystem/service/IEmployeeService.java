package com.lautajam.AccessSystem.service;

import com.lautajam.AccessSystem.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeeService {

    /**
     * Save employee to database
     * @param employee Employee to save to database
     * @return Employee saved to database
     */
    public void saveEmployee(Employee employee);

    /**
     * Get employee by id from database
     * @return A list of employee from database
     */
    public List<Employee> getAllEmployees();

    /**
     * Get employee by id from database
     * @param employee_id ID of employee to get from database
     * @return Employee from database
     */
    public Employee getEmployeeById(long employee_id);

    /**
     * Update employee in database with given employee
     * @param employee Employee to update in database
     * @return Employee updated in database
     */
    public void updateEmployee(Employee employee);

    /**
     * Delete employee in database with given employee
     * @param employee_id ID of employee to delete in database
     * @return Employee deleted in database
     */
    public void deleteEmployeeById(long employee_id);
}
