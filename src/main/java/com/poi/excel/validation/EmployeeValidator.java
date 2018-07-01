package com.poi.excel.validation;

public class EmployeeValidator {

	private Employee deligate;
	private int rowIndex;
	private EmployeeValidationError validationError;
	private static MockEmployeeDAO employeeDAO = new MockEmployeeDAO();

	public EmployeeValidator(Employee employee, int rowIndex) {
		deligate = employee;
		this.rowIndex = rowIndex;
	}

	boolean validate() {
		Employee emp = employeeDAO.findByEmpId(deligate.getEmpId());
		if (!deligate.equals(emp)) {
			validationError = new EmployeeValidationError(rowIndex, "Not same with DB", deligate);
			return false;
		}
		return true;

	}

	public EmployeeValidationError getValidationError() {
		return validationError;
	}

	@Override
	public String toString() {
		return "EmployeeValidator [deligate=" + deligate + ", rowIndex=" + rowIndex + ", validationError="
				+ validationError + "]";
	}

}
