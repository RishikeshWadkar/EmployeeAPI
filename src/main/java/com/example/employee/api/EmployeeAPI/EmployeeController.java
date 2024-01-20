package com.example.employee.api.EmployeeAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeByID(@PathVariable("id") Integer id) {
        System.out.println("getting employee by id:: "+ id);
        System.out.println("getting employee by id:: "+ employeeService.getEmployeeByID(id));
        return employeeService.getEmployeeByID(id);
    }

    @PostMapping("/employee/addnew")
    public void addEmployee(@RequestBody Employee employee) {
        if (!employeeService.existByEmail(employee.getEmail())) {
            employeeService.addEmployee(employee);
            System.out.println("Adding a new employee :: " + employee);
        }
    }

    @PostMapping("/employees/addnew")
    public void addEmployee(@RequestBody List<Employee> employees) {
        if (!employeeService.existByEmail(employees.getFirst().getEmail())) {
            employeeService.addEmployees(employees);
            System.out.println("Adding list of employees :: " + employees);
        }
    }

    @PutMapping("/employee/{id}/edit")
    public void updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employee/{id}/delete")
    public void deleterEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
        System.out.println("Deleting of employees :: " + id);
    }

    @GetMapping("/employees/search/{query}")
    public List<Employee> searchEmployees(@PathVariable("query") String query) {
        return employeeService.searchEmployee(query);
    }
}
