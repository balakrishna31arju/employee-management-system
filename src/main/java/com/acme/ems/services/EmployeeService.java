package com.acme.ems.services;

import com.acme.ems.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeService extends CrudRepository<Employee, Integer> {

}
