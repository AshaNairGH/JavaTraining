package com.example.demo_resttemplate;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.params.provider.Arguments;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ExcelReadUtils {
	
	private static Workbook wbook;
	private static Sheet sheet;
	private static int current_row_num;
	
	
	//create one more method which opens excel file, sheet, row
	public static void init() {
		try {	
		//read test data from excel
		FileInputStream fis = new FileInputStream("D:\\Softwares\\Book2.xlsx");

		// read workbook
		wbook = new XSSFWorkbook(fis);
		
		//open sheet 
		sheet = wbook.getSheetAt(0);
		
		current_row_num=0;
		
		}catch(Exception en) {
			System.out.println("Exception in init:"+en.getMessage());
		}

	}

	public static Stream<Arguments> fetchTicketIds() {
		List<Arguments> args = new ArrayList<>();
		
		//fetch no.of test data rows dynamically
		Row row = sheet.getRow(current_row_num++);
		Cell cell1 = row.getCell(0);
		int num_of_testcases = (int) cell1.getNumericCellValue();
		
		//fetch no.of rows and return Stream<Arguments>
		
		try {
				for (int i = current_row_num; i < (current_row_num+num_of_testcases); i++) {
				// fetch each rows
				Row rowi = sheet.getRow(i);

				// read first column - ticketid
				Cell celltid = rowi.getCell(0);
				int ticketid = (int) celltid.getNumericCellValue();
				
				// read second  column - fromplace
				Cell cellfp = rowi.getCell(1);
				String fromplace = cellfp.getStringCellValue();
				
				// read third column - toplace
				Cell celltp = rowi.getCell(2);
				String toplace = celltp.getStringCellValue();

				// read fourth column - price
				Cell cellprice = rowi.getCell(3);
				float price = (float) cellprice.getNumericCellValue();
				
				args.add(Arguments.of(ticketid, fromplace, toplace, price));
			}
		} catch (Exception e) {
			System.out.println("Exceptionnnn"+e.getMessage());
			e.printStackTrace();
		}

		//create and return stream from list of Junit arguments
		return args.stream();
	}
	
	public static Stream<Arguments> readTicketJson() {
		List<Arguments> args = new ArrayList<>();
		try {
			// read from excel
			// create Stream
			// and return, Stream
			//System.out.println("File path:"+excelfilename);
			FileInputStream fis = new FileInputStream("D:\\Softwares\\Book2.xlsx");

			// read workbook
			Workbook wbook = new XSSFWorkbook(fis);

			double value = 0;

			int no_of_rows = 0;
			Sheet st = null;

			// read sheet
			st = wbook.getSheetAt(0);

			//fetch no.of rows in excel
			no_of_rows = st.getPhysicalNumberOfRows();

			for (int i = 0; i < no_of_rows; i++) {
				// fetch each rows
				Row row = st.getRow(i);

				int no_of_cols = row.getLastCellNum();

				// read first column - ticket json
				Cell cell1 = row.getCell(0);
				String ticketjson = cell1.getStringCellValue();
				
				// read second column - username
				Cell cell2 = row.getCell(1);
				String username = cell2.getStringCellValue();
				
				//add each test data bundle to list
				args.add(Arguments.of(ticketjson,username));
			}

			wbook.close();
			fis.close();
		} catch (Exception e) {
			System.out.println("Exceptionnnn"+e.getMessage());
			e.printStackTrace();
		}

		//create and return stream from list of Junit arguments
		return args.stream();
	}
	
	
	Ticket fetchTicket(ResultActions resultActions) throws Exception{
	  String jsonresponse = resultActions.andReturn().getResponse().getContentAsString();
	  System.out.println("Json Response: "+jsonresponse);
	  
	  //json string to json obj 
	  ObjectMapper omapper = new ObjectMapper();
	  Ticket ticket = omapper.readValue(jsonresponse, Ticket.class);
	  return ticket;
	}
}
