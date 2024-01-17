package com.example.employee.api.EmployeeAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/employee/addnew")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        System.out.println("Adding a new employee :: " + employee);
    }

    @PostMapping("/employees/addnew")
    public void addEmployee(@RequestBody List<Employee> employees) {
        employeeService.addEmployees(employees);
        System.out.println("Adding list of employees :: " + employees);
    }

    @PutMapping("/employees/{id}/edit")
    public void updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{id}/delete")
    public void deleterEmployee(@PathVariable("id") Integer id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/employees/search/{query}")
    public List<Employee> searchEmployees(@PathVariable("query") String query) {
        return employeeService.searchEmployee(query);
    }
}
