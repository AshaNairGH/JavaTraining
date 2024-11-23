package com.exceleg;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteEg {
public static void main(String[] args) throws Exception{
	//create workbook
	Workbook wbook = new XSSFWorkbook();
	
	//create a new sheet
	Sheet st = wbook.createSheet("First sheet");
	Sheet st1 = wbook.createSheet("Second sheet");
	
	//create row 
	Row row = st.createRow(0);
		
	//create cell and set some value in the above row
	/*Cell cell = row.createCell(0);
	cell.setCellValue("Hello");*/
	
	
	Cell cell = row.createCell(0, CellType.NUMERIC);
	cell.setCellValue(12);
	
	//add value in 1B
//	Cell cell3 = row.createCell(1, CellType.NUMERIC);
//	cell3.setCellValue(0);
	
	Row row1 = st.createRow(1);
	Cell cell1 = row1.createCell(0, CellType.NUMERIC);
	cell1.setCellValue(13);
	
	Row row2 = st.createRow(2);
	Cell cell2 = row2.createCell(0, CellType.NUMERIC);
	cell2.setCellValue(52);
	
	//Add value in second sheet first row
	Row rows2=st1.createRow(0);
	Cell cells2 = rows2.createCell(0, CellType.NUMERIC);
	cells2.setCellValue(0);

	
	FileOutputStream fos = new FileOutputStream("firstexcel.xlsx");
	
	//write above excel to a file
	wbook.write(fos);
	wbook.close();
	fos.close();
}
}
