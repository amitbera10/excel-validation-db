package com.poi.excel.validation;

public class EmployeeValidationError {
	int rowNo;
	String message;
	Employee employee;

	public EmployeeValidationError(int rowNo, String message, Employee employee) {
		super();
		this.rowNo = rowNo;
		this.message = message;
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeValidationError [rowNo=" + rowNo + ", message=" + message + ", employee=" + employee + "]";
	}

}
