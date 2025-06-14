package com.omrbranch.day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xdgf.util.Util;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OmrBranchTask1 {
	
	public static void main(String[] args) throws IOException {
		
		//Mention the path of Excel 
		
		File file = new File("C:\\Users\\mathi\\eclipse-workspace-Selenium\\FrameWorkClass-Mathiyazhagan\\Excel sheet\\Sheet.xlsx");
		
		//get the objects/bytes from the file 
		
		FileInputStream fileInputStream = new FileInputStream(file);
		
		//mention the workbook -->collection of sheets 
		
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		
		//get the sheet 
		 
		Sheet sheet = workbook.getSheet("login");
		
		//iterate the rows 
		
		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
			
			//get the each rows 
			Row row = sheet.getRow(i);
			
			//iterate the each cells 
			for(int j = 0;j<row.getPhysicalNumberOfCells();j++) {
				
				//get all cells 
				Cell cell = row.getCell(j);
				CellType type = cell.getCellType();
				switch(type) {
				case STRING:
				String value = cell.getStringCellValue();
				System.out.println(value);
				break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-YYYY");
						String format = dateFormat.format(dateCellValue);
						System.out.println(format);
						
					}
					
					else {
						double d = cell.getNumericCellValue();
						long round = Math.round(d);
						if(round==d) {
							String valueOf = String.valueOf(round);
							System.out.println(valueOf);
						}else {
							String valueOf = String.valueOf(d);
							System.out.println(valueOf);
						}
						
					}
					break;
					default:
						break;
			}
			
								
			}
			
		}
		 
		 
		
	
		
	}

}
