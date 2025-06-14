package com.omrbranch.day8;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetTask3 {
	public static void main(String[] args) throws IOException  {
		
	File file = new File("C:\\Users\\mathi\\eclipse-workspace-Selenium\\FrameWorkClass-Mathiyazhagan\\Excel sheet\\Book2.xlsx");	
	
	Workbook workbook = new XSSFWorkbook();
	
	Sheet sheet = workbook.createSheet("Login");
	
	Row row = sheet.createRow(10);
	
	Cell cell = row.createCell(5);
	cell.setCellValue("java");
	
	Cell cell2 = row.createCell(6);
	cell2.setCellValue("java");
	
	FileOutputStream fileOutputStream = new FileOutputStream(file);
	
	workbook.write(fileOutputStream);
	
	System.out.println("done....");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
