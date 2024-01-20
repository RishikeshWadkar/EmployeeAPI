package com.example.employee.api.EmployeeAPI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByNameStartingWithIgnoreCase(String firstName);

    boolean existsByEmail(String email);

}
