package org.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFCell cell;
	public static XSSFRow row;
	public static CellStyle style;

	//	getPhysicalNumberOfRows
	//	ws.getRow(0).getPhysicalNumberOfCells
	//	ws.getRow(rowNum).getCell(colNum).getStringCellValue()
	//	ws.getRow(rowNum).getCell(colNum).getNumericCellValue()
	//	ws.getLastRowNum
	//	row.getLastCellNum()
	//	row.getCell(column)
	//	row = ws.getRow(rownum);
	//	cell = row.createCell(column);
	//	c1.getStringCellValue()

	public static void ExcelUtils(String excelPath,String sheetName) {
		try {
			wb = new XSSFWorkbook(excelPath);
			ws = wb.getSheet(sheetName);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static int getRowCount() {
		int rowCount =0 ;
		try {
			rowCount = ws.getPhysicalNumberOfRows();
			System.out.println("No of rows = "+rowCount);
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;
	}

	public static int getColCount() {
		int colCount = 0;
		try {
			colCount = ws.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No of columns = "+colCount);
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colCount;
	}
	public static String getCellDataString(int rowNum, int colNum) {
		String cellData = "";
		try {
			cellData = ws.getRow(rowNum).getCell(colNum).getStringCellValue();
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;
	}

	public static void getCellDataNumber(int rowNum, int colNum) {
		try {
			double cellData = ws.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//			System.out.println(cellData);
		}catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

	public static int getRowCount(String xlfile,String xlsheet,int rownum, int column, String data) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlfile);
		row = ws.getRow(rownum);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}	

	public static int getCellCount(String xlfile,String xlsheet,int rownum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}

	public static String getCellData(String xlfile, String xlsheet, int rownum, int column) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(column);
		String data;
		try {
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);

			return cellData;
		} catch (Exception e) {
			data = "";
		}
		wb.close();
		fi.close();
		return data;
	}

	public void setCellData(String xlfile,String xlsheet,int rownum, int column, String data) throws IOException {
		FileInputStream  fi = new FileInputStream(xlfile);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.createCell(column);
		cell.setCellValue(data);

		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	public String getParticularStringCellValue(String filePath,String sheetName,int rowNum,int cellNum) {
		String text = "";
		try {
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s1 = wb.getSheet("sheetName");
			Row r1 = s1.getRow(rowNum);
			Cell c1 = r1.getCell(cellNum);
			//			Cell c1 = WorkbookFactory.create(fis).getSheet("sheetName").getRow(rowNum).getCell(cellNum);
			text = c1.getStringCellValue();
			System.out.println("text = "+text);
			return text;
		}catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("text = "+text);
		return text;
	}
}