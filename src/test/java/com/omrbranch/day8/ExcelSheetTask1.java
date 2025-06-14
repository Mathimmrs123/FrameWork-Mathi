package com.omrbranch.day8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetTask1 {
	public static void main(String[] args) throws IOException {
		
		
		File file = new File("C:\\Users\\mathi\\eclipse-workspace-Selenium\\FrameWorkClass-Mathiyazhagan\\Excel sheet\\Sheet.xlsx");
		
		FileInputStream fileInputStream = new FileInputStream(file);
		
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		
		Sheet sheet = workbook.getSheet("login");
		
		Row row = sheet.getRow(2);
		
		Cell cell = row.getCell(1);
		
		String value = cell.getStringCellValue();
		
		if(value.equals("mozhi")) {
			cell.setCellValue("ramesh");
		}
		
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		
		workbook.write(fileOutputStream);
		
		System.out.println("Done ........");
		
		
	}

	
}
