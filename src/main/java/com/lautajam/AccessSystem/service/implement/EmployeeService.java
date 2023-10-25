package com.lautajam.AccessSystem.service.implement;

import com.lautajam.AccessSystem.model.Employee;
import com.lautajam.AccessSystem.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lautajam.AccessSystem.service.IEmployeeService;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    /**
     * The employee repository to be injected. This repository provides access to the database.
     * This repository is used for tasks such as creating, updating, and retrieving employee
     * information from the database.
     */
    @Autowired
    private IEmployeeRepository employeeRepository;

    /**
     * Save employee to database
     * @param employee Employee to save to database
     * @return Employee saved to database
     */
    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    /**
     * Get employee by id from database
     * @return A list of employee from database
     */
    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

    /**
     * Get employee by id from database
     * @param employee_id ID of employee to get from database
     * @return Employee from database
     */
    @Override
    public Employee getEmployeeById(long employee_id) {
        Employee employeeById = employeeRepository.findById(employee_id).orElse(null);
        return employeeById;
    }

    /**
     * Update employee in database with given employee
     * @param employee Employee to update in database
     * @return Employee updated in database
     */
    @Override
    public void updateEmployee(Employee employee) {
        this.saveEmployee(employee);
    }

    /**
     * Delete employee in database with given employee
     * @param employee_id ID of employee to delete in database
     * @return Employee deleted in database
     */
    @Override
    public void deleteEmployeeById(long employee_id) {
        employeeRepository.deleteById(employee_id);
    }
}
