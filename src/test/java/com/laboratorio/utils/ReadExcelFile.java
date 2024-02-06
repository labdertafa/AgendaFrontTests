package com.laboratorio.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	public void readExcel(String filepath, String sheetName) throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int i= 0; i < rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.println(row.getCell(j).getStringCellValue() + "||");
			}
		}
		
		inputStream.close();
		workbook.close();
	}
	
	public static int getRowCount(String filepath, String sheetName) throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		return sheet.getLastRowNum() - sheet.getFirstRowNum();
	}
	
	public static String[] getRowValues(String filepath, String sheetName, int rowNumber) throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		XSSFRow row = sheet.getRow(rowNumber);
		String valores[] = new String[row.getLastCellNum()];
		for (int i = 0; i < row.getLastCellNum(); i++) {
			valores[i] = row.getCell(i).getStringCellValue();
		}
		
		return valores;
	}
	
	public static String getCellValue(String filepath, String sheetName, int rowNumber, int cellNumber) throws IOException {
		File file = new File(filepath);
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		XSSFRow row = sheet.getRow(rowNumber);
		XSSFCell cell = row.getCell(cellNumber);
		
		inputStream.close();
		workbook.close();
		
		return cell.getStringCellValue();
	}
}