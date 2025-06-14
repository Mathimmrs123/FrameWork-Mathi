package com.omrbranch.day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OmrBranchTask1 {
	public static void main(String[] args) throws IOException {
		
		File file =new File("C:\\Users\\mathi\\eclipse-workspace-Selenium\\FrameWorkClass-Mathiyazhagan\\Excel sheet\\Book1.xlsx");
		
		FileInputStream fileInputStream = new FileInputStream(file);
		
		Workbook workBook = new XSSFWorkbook(fileInputStream);
		
		Sheet sheet = workBook.getSheet("Sheet1");
		
		Row row = sheet.getRow(9);
		
		for (int i=0;i<row.getPhysicalNumberOfCells();i++) {
	
		Cell cell = row.getCell(i);
		System.out.println(cell);
		//Cell cell = row.getCell(1);
		
	//	System.out.println(cell);
	
		
	}

	}}

