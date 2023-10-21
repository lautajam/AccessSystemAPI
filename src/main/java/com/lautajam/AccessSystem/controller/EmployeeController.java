package com.lautajam.AccessSystem.controller;

import com.lautajam.AccessSystem.model.Employee;
import com.lautajam.AccessSystem.service.implement.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {


    /**
     * The employee service to be injected. This service provides access to the database
     * for retrieving and managing employee-related data.
     * This service is used for tasks such as creating, updating, and retrieving employee
     * information from the database.
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * Creates a new employee in the system using the provided data.
     *
     * @param employee The Employee object containing the information of the employee to be created.
     * @return ResponseEntity with the operation status:
     *         - HttpStatus.CREATED (201) if the employee is successfully created.
     *         - HttpStatus.INTERNAL_SERVER_ERROR (500) if an error occurs during the operation.
     */
    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        try {
            employeeService.saveEmployee(employee);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Retrieves a list of all employees in the system.
     *
     * @return ResponseEntity with the list of employees and the status of the operation:
     *         - HttpStatus.OK (200) if the list of employees is successfully retrieved.
     *         - HttpStatus.NO_CONTENT (204) if no employees are found.
     */
    @GetMapping("/getAll")
    @ResponseBody
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> allEmployeeList = employeeService.getAllEmployees();
        if (!allEmployeeList.isEmpty())
            return new ResponseEntity<>(allEmployeeList, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Retrieves an employee by its id.
     *
     * @param employee_id The id of the employee to be retrieved.
     * @return ResponseEntity with the employee and the status of the operation:
     *         - HttpStatus.OK (200) if the employee is successfully retrieved.
     *         - HttpStatus.NO_CONTENT (204) if no employee is found.
     */
    @GetMapping("/get/{employee_id}")
    @ResponseBody
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employee_id){

        Employee employee = employeeService.getEmployeeById(employee_id);
        if (employee != null)
            return new ResponseEntity<>(employee, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Update a employee in the system using the provided data.
     *
     * @param employee The Employee object containing the information of the employee to be updated.
     * @return ResponseEntity with the employee and the status of the operation:
     *         - HttpStatus.OK (200) if the employee is successfully retrieved.
     *         - HttpStatus.NO_CONTENT (204) if no employee is found.
     */
    @PutMapping("/update")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
        try {
            employeeService.updateEmployee(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete a employee in the system using the provided data.
     *
     * @param employee_id The id of the employee to be deleted.
     * @return ResponseEntity with the employee and the status of the operation:
     *         - HttpStatus.OK (200) if the employee is successfully retrieved.
     *         - HttpStatus.NO_CONTENT (204) if no employee is found.
     */
    @DeleteMapping("/delete/{employee_id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employee_id){
        try {
            employeeService.deleteEmployeeById(employee_id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
