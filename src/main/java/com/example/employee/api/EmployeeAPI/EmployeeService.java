package com.example.employee.api.EmployeeAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void addEmployees(List<Employee> employee) {
        employeeRepository.saveAll(employee);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> searchEmployee(String query) {
        List<Employee> searchListEmployee = employeeRepository.findByFirstNameContaining(query);
        System.out.println("searchEmployee :: " + searchListEmployee);
        return searchListEmployee;
    }
}
