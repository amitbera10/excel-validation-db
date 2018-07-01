package com.poi.excel.validation;

public class MockEmployeeDAO implements IEmployeeDAO {

	public Employee findByEmpId(String empId) {
		return Bootstrap.employees.stream().filter(e -> e.getEmpId().equals(empId)).findFirst().orElse(null);
	}

}
