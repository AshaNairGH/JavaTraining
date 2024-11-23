package com.exceleg;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite2Eg {

	static String sarr[][]= {{"dfdfdfd", "gfdgdfgdfgdf", "gfdfg"},
			{"sdasafsadf","asasasas","werwrwerew"},
			{"bbbbb","asdasds","cccccc"}};
	public static void main(String[] args) {
		
		try {
		//create workbook
		Workbook wbook = new XSSFWorkbook();
		
		//create a new sheet
		Sheet st = wbook.createSheet("First sheet");
		
		for(int i = 0;i<sarr.length;i++) {
			//create row
			Row row = st.createRow(i);
			for (int j = 0; j < sarr[0].length; j++) {
				//create cell and set value
				Cell cell = row.createCell(j);
				cell.setCellValue(sarr[i][j]);
				System.out.print("Writing the element " + sarr[i][j] + " to excel");
			}
			System.out.println();
		}
		
		//FileOutputStream fos = new FileOutputStream("D:\\Projects\\secondexcel.xlsx");
		FileOutputStream fos = new FileOutputStream("../secondexcel.xlsx");
		wbook.write(fos);
		
		}catch(Exception et) {
			et.printStackTrace();
		}
		
}
}
