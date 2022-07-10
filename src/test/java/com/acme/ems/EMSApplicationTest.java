package com.acme.ems;

import com.acme.ems.controllers.EmployeeController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class EMSApplicationTest {

	@Autowired
	EmployeeController employeeController;

	@Test
	public void contextLoads() {

		Assert.assertNotNull(employeeController);
	}
}
