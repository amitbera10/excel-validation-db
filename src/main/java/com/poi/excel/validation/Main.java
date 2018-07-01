package com.poi.excel.validation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

	public static void main(String args[]) throws IOException {
		Bootstrap.init();
		String excelFilePath = "/home/amit/Desktop/emp.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		int row = 0;

		List<EmployeeValidator> empValidatorList = new ArrayList();

		while (iterator.hasNext()) {
			int col = 0;
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			if (row != 0) {
				EmployeeValidatorBuilder builder = new EmployeeValidatorBuilder().withRow(row);
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					Object value = null;
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						value = cell.getStringCellValue();
						System.out.print(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:

						value = cell.getNumericCellValue();
						System.out.print(cell.getNumericCellValue());
						break;
					}
					builder.withField(col, value);
					col++;
				}

				EmployeeValidator employeeValidator = builder.build();
				empValidatorList.add(employeeValidator);

				System.out.println();
			}
			row++;
		}
		inputStream.close();

		validate(empValidatorList);
	}

	private static void validate(List<EmployeeValidator> empValidatorList) {
		List<EmployeeValidationError> employeeValidationErrors = empValidatorList.parallelStream()
				.filter(empVal -> !empVal.validate()).map(empVal -> empVal.getValidationError())
				.collect(Collectors.toList());
		System.out.println(employeeValidationErrors);
	}

}
