package com.example.demo_resttemplate;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.annotation.PostConstruct;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import org.springframework.test.web.servlet.*;

//import static java.lang.System.*;
@SpringBootTest
@AutoConfigureMockMvc
class DemoResttemplateApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	
	private static Workbook wbook;
	private static Sheet st;
	
	@Autowired
	ExcelReadUtils eRUtils;
	
	@Autowired
	ExcelWriteUtils eWUtils;
		
	 
	@BeforeAll
	static void metb() {		
		ExcelReadUtils.init();
		//open or create excel (Test report)
		//create workbook
		 wbook = new XSSFWorkbook();
		
		//create a new sheet
		st = wbook.createSheet("First sheet");
	}
	
	@BeforeEach
	void met() {

	}

	  static Stream<Arguments> wFetchTicketIds(){
		  ExcelReadUtils.init();
		return ExcelReadUtils.fetchTicketIds();
	}
	
	/*
	 * private static Stream<Arguments> fetchTicketIds(){ return
	 * Stream.of(Arguments.of(8,"jjjjjj","kkkkk"),
	 * Arguments.of(9,"Place10000","Place210000"),
	 * Arguments.of(10,"Place10000","Place210000") ); }
	 */
	
	

	@ParameterizedTest
	@MethodSource("wFetchTicketIds")
	void testGetTicket(int ticketid, String fromplace, String toplace, float price) throws Exception{
		try {
		ResultActions resultActions = mockMvc.perform(get("/redbus/"+ticketid))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.fromplace").value(fromplace))
		.andExpect(jsonPath("$.toplace").value(toplace))
		.andExpect(jsonPath("$.price").value(price));
		//.andDo(print());
		
		Ticket ticket = eRUtils.fetchTicket(resultActions);
		  System.out.println("From place: " +ticket.getFromplace());
		}catch(AssertionError ae) {
			//create row in excel
			eWUtils.createTestResultRow("Testcase: Failed",st);
			throw(ae);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
				// create row in excel
		eWUtils.createTestResultRow("Testcase: passed",st);
				System.out.println("----------------------------------------");
	}
	
	/*
	 * @AfterEach void metae() { test_case_num++; }
	 */
	
	
	
	@AfterAll
	static void meta() {
		
		try {
			//close excel
			FileOutputStream fos = new FileOutputStream("testreport.xlsx");
			
			//write above excel to a file
			wbook.write(fos);
			wbook.close();
			fos.close();
		}catch(Exception e) {
			System.out.println("Exceptionaa:"+e.getMessage());
		}
	}
	
	
	static Stream<Arguments> excelReadTicketJson(){
		return ExcelReadUtils.readTicketJson();
	}
	
	@Disabled
	//@ParameterizedTest
	//@MethodSource("excelReadTicketJson")
	void testBookTicket(String ticketjson,String username) throws Exception{
		
		//call method which reads JSON from excel
		try {
	mockMvc.perform(post("/redbus")
			.contentType(MediaType.APPLICATION_JSON)
			.content(ticketjson))
			//.content("{\"username\":\"user456\",\"fromplace\":\"tuvm\",\"toplace\":\"klmn\",\"email\":\"987652@gmail.com\",\"price\":9876.5}"))
	.andExpect(status().isCreated())
	.andExpect(content().contentType(MediaType.APPLICATION_JSON))
	//.andDo(print())
	.andExpect(jsonPath("$.username").value(username));	
	}
		catch(AssertionError e) {		
System.out.println("Test case: Fail\n"+e.getMessage());
eWUtils.createTestResultRow("Testcase: Fail",st);
throw e;
		}catch(Exception e) {
			System.out.println("Exception"+e.getMessage());
		}
		eWUtils.createTestResultRow("Testcase: pass",st);
		System.out.println("Test case: Pass");
	}
		
	
	//@Test
	@Disabled
	void testUpdateTicket() throws Exception{
		mockMvc.perform(put("/redbus/15").contentType(MediaType.APPLICATION_JSON)
				.content("{\"username\":\"user456\",\"fromplace\":\"jjjjjj\",\"toplace\":\"kkkkk\",\"email\":\"987652@gmail.com\",\"price\":9876.5}"))
		.andExpect(status().isCreated());
	}
	
	//@Test
	@Disabled
	void testcancelTicket() throws Exception{
		mockMvc.perform(delete("/redbus/18"))
		.andExpect(status().isOk());
	}

}
