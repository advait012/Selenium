package com.project.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.project.Configuration.Configuration;

public class ExcelReader {

	public static String ExcelFileLocation = Configuration.TESTDATA_PATH;

	public static String getCell(int sheetNo, int row, int column) throws IOException {

		int i = row;
		String value = null;
		File file = new File(ExcelFileLocation);
		FileInputStream fileStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
		XSSFSheet sheet = workbook.getSheetAt(sheetNo);
		try {
			XSSFCell cell = sheet.getRow(i).getCell(column);
			if (cell.getCellTypeEnum() == CellType.STRING) {
				value = cell.getStringCellValue().toString();

			} else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
				value = NumberToTextConverter.toText(cell.getNumericCellValue());

				// Double.toString(cell.getNumericCellValue()).toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		workbook.close();
		return value;
	}

	public static void setCell(int sheetNo, int row, int column, String str) throws IOException {
		int i = row;
		File file = new File(ExcelFileLocation);
		FileInputStream fileStream = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
		XSSFSheet sheet = workbook.getSheetAt(sheetNo);
		XSSFRow rows = sheet.getRow(i);
		if (rows == null) {
			rows = sheet.createRow(i);
		}
		try {
			rows.getCell(column).setCellValue(str);
		} catch (Exception e) {
			rows.createCell(column).setCellValue(str);

		}
		FileOutputStream fout = new FileOutputStream(new File(ExcelFileLocation));
		workbook.write(fout);
		fout.close();
	}

}
