package com.example.testing.demo.repository;

import com.example.testing.demo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findAll();

    List<Employee> findAllById(Iterable<Long> employeeIds);

}
