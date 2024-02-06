package com.laboratorio.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {
	public WriteExcelFile() {
	}

	public void writeExcel(String filepath, String sheetName, String[] dataToWrite) throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		XSSFRow row = sheet.createRow(rowCount + 1);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			XSSFCell cell = row.createCell(i);
			cell.setCellValue(dataToWrite[i]);
		}
		
		inputStream.close();
		
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		outputStream.close();
		workbook.close();
	}
	
	public void writeCellValue(String filepath, String sheetName, int rowNumber, int cellNumber, String resultText) throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		XSSFRow row = sheet.getRow(rowNumber);
		
		XSSFCell cell = row.getCell(cellNumber - 1);
		System.out.println("First cell value is: " + cell.getStringCellValue());
		
		XSSFCell nextCell = row.createCell(cellNumber);
		nextCell.setCellValue(resultText);
		System.out.println("Next cell value is: " + nextCell.getStringCellValue());
		
		inputStream.close();
		
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		outputStream.close();
		workbook.close();
	}
}