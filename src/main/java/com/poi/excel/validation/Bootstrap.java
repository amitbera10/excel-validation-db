package com.poi.excel.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bootstrap {

	public static List<Employee> employees;

	public static void init() {
		Employee employee1 = new Employee("E101", "Jhon", "jon@gmail.com", "+91-77777777");
		Employee employee2 = new Employee("E102", "Lea", "lea@gmail.com", "+91-88888888");
		Employee employee3 = new Employee("E103", "Andru", "andru@gmail.com", "+91-77777777");
		employees = Arrays.asList(employee1, employee2, employee3);
	}

}
