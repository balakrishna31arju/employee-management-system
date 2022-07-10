package com.acme.ems;

import com.acme.ems.controllers.EmployeeController;
import com.acme.ems.model.Employee;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ValidationException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrationTest {

    @Autowired
    EmployeeController employeeController;

    @Test
    public void testCreateReadDelete()throws ValidationException{
        Employee employee = new Employee("Karthik","9876547687","IT","karthik@gmail.com","Bengaluru","Employee");
        try {
            Employee savedEmployee = employeeController.addEmployee(employee);
        }catch (javax.xml.bind.ValidationException e) {
            throw new RuntimeException(e);
        }

        Iterable<Employee> employeeList = employeeController.listEmployee();
        Assertions.assertThat(employeeList).first().hasFieldOrPropertyWithValue("empName", "Karthik");

        employeeController.deleteEmployee(employee.getEmpID());
        Assertions.assertThat(employeeController.listEmployee()).isEmpty();

    }

    @Test(expected = ValidationException.class)
    public void checkingWrongUrl() {
        employeeController.enteredWrongUrl();

    }

}