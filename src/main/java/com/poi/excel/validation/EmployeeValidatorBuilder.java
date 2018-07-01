package com.poi.excel.validation;

public class EmployeeValidatorBuilder {

	private Employee employee;

	private int rowIndex;

	public EmployeeValidatorBuilder() {
		employee = new Employee();
	}

	EmployeeValidatorBuilder withRow(int excelRowIndex) {
		this.rowIndex = excelRowIndex;
		return this;
	}

	EmployeeValidatorBuilder withField(int excelColIndex, Object value) {
		switch (excelColIndex) {
		case 0:
			employee.setEmpId((String) value);
			break;
		case 1:
			employee.setName((String) value);
			break;
		case 2:
			employee.setEmail((String) value);
			break;
		case 3:
			employee.setPhoneNo((String) value);
			break;

		default:
			throw new IllegalArgumentException();

		}
		return this;
	}

	EmployeeValidator build() {
		return new EmployeeValidator(employee, rowIndex);
	}

}
