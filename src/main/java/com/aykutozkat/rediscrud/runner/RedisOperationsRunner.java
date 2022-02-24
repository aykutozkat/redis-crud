package com.aykutozkat.rediscrud.runner;

import com.aykutozkat.rediscrud.dao.IEmployeeDao;
import com.aykutozkat.rediscrud.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RedisOperationsRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeDao dao;

	@Override
	public void run(String... args) {
		//saving one employee
		dao.saveEmployee(new Employee(500, "Emp0", 2150.0));

		//saving multiple employees
		dao.saveAllEmployees(
				Map.of(501, new Employee(501, "Emp1", 2396.0),
						502, new Employee(502, "Emp2", 2499.5),
						503, new Employee(503, "Emp4", 2324.75)
				)
		);

		//modifying employee with empId 503
		dao.updateEmployee(new Employee(503, "Emp3", 2325.25));

		//deleting employee with empID 500
		dao.deleteEmployee(500);

		//retrieving all employees
		dao.getAllEmployees().forEach((k, v) -> System.out.println(k + " : " + v));

		//retrieving employee with empID 501
		System.out.println("Emp details for 501 : " + dao.getOneEmployee(501));
	}

}