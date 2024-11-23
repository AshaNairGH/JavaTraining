package com.exceleg;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Multiple sheets, multiple rows, multiple columns
public class ExcelReadEg {
	/*
	 * public static void main(String[] args) throws FileNotFoundException,
	 * IOException{ //open file FileInputStream fis = new
	 * FileInputStream("../firstexcel.xlsx"); //read workbook Workbook wbook = new
	 * XSSFWorkbook(fis); System.out.println("No. of sheets" +
	 * wbook.getNumberOfSheets());
	 * 
	 * int no_of_sheet = wbook.getNumberOfSheets(); double value = 0; int
	 * no_of_rows=0; Sheet st=null; for(int k = 0; k<no_of_sheet;k++) {
	 * 
	 * //read sheet st = wbook.getSheetAt(k);
	 * 
	 * no_of_rows = st.getPhysicalNumberOfRows();
	 * 
	 * for(int i =0; i<no_of_rows;i++) { //read rows Row row = st.getRow(i); int
	 * no_of_cols = row.getLastCellNum(); for(int j = 0;j<no_of_cols;j++) { //read
	 * cells Cell cell = row.getCell(j); value = value + cell.getNumericCellValue();
	 * //System.out.println(cell.getStringCellValue()); } } }
	 * System.out.println("sum is : "+value); wbook.close(); fis.close();
	 * 
	 * 
	 * 
	 * FileOutputStream fos = new FileOutputStream("../firstexcel.xlsx"); Workbook
	 * wbook1 = new XSSFWorkbook();
	 * 
	 * Sheet st1 = wbook1.getSheetAt(0); Row row = st1.createRow(no_of_rows+1);
	 * 
	 * System.out.println("sum is: " + value); Row row = st.createRow(no_of_rows+1);
	 * Cell cell = row.createCell(0); cell.setCellValue(value);
	 * 
	 * }
	 */
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// open file
		FileInputStream fis = new FileInputStream("./firstexcel.xlsx");

		// read workbook
		Workbook wbook = new XSSFWorkbook(fis);

		System.out.println("No. of sheets" + wbook.getNumberOfSheets());

		int no_of_sheets = wbook.getNumberOfSheets();
		
		double value = 0;

		int no_of_rows = 0;
		Sheet st = null;
		for (int k = 0; k < no_of_sheets; k++) {
			// read sheet
			st = wbook.getSheetAt(k);

			no_of_rows = st.getPhysicalNumberOfRows();

			for (int i = 0; i < no_of_rows; i++) {
				// read rows
				Row row = st.getRow(i);

				int no_of_cols = row.getLastCellNum();

				for (int j = 0; j < no_of_cols; j++) {
					// read cells
					Cell cell = row.getCell(j);

					value = value + cell.getNumericCellValue();
				}
			}
		}
		System.out.println("sum is "+value);
		wbook.close();
		fis.close();
		
/*
		FileOutputStream fos = new FileOutputStream("./firstexcel.xlsx");
		Workbook wbook1 = new XSSFWorkbook(fis);
		Sheet st1 = wbook1.getSheetAt(0);
		Row row = st.createRow(no_of_rows+1);
		System.out.println("Created row..."+(no_of_rows));
		Cell cell = row.createCell(0);
		cell.setCellValue(value);

		wbook1.write(fos);
		wbook1.close();
		fos.close();*/

	}
}
