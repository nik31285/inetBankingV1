package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class XLReader {
	public static FileInputStream fs;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static int getRowCount(String xlfile,String sheetName) throws IOException {
		fs=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fs);
		sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		workbook.close();
		fs.close();
		return rowCount;
	}
	
	public static int getCellCount(String xlFile,String sheetName,int rowNum) throws IOException {
		fs=new FileInputStream(xlFile);
		workbook=new XSSFWorkbook(fs);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		int cellCount= row.getLastCellNum();
		workbook.close();
		fs.close();
		return cellCount;
	}
	
	public static String getCellData(String xlFile,String sheetName,int rowNum,int cellNum) throws IOException {
		fs=new FileInputStream(xlFile);
		workbook=new XSSFWorkbook(fs);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(cellNum);
		String data;
		try {
			DataFormatter formatter=new DataFormatter();
			String cellData=formatter.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e){
			data="";
		}
		workbook.close();
		fs.close();
		return data;
	}
}
