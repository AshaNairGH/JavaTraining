package com.example.demo_resttemplate;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.demo_resttemplate.ExcelReadUtils;

public class MainTestAppJunit {
	
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	@BeforeAll
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

		//create driver instance
		driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		ExcelReadUtils.init();
	}
		
		@Test
		public void testNavigateHomeAbout() {
			//load web page
			driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumeg_pomm\\src\\main\\resources\\Home.html");
			//create home page instance
			HomePage homePage = new HomePage(driver);
			AboutPage aboutPage = homePage.gotoAboutPage();
			//wait until page is loaded
			wait.until(ExpectedConditions.titleContains("About"));
			//assert with page title
			assertTrue(driver.getTitle().contains("About"));
		}
		
		@Test
		public void testNavigateHomeContact() {
			//load web page
			driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumeg_pomm\\src\\main\\resources\\Home.html");
			//create home page instance
			HomePage homePage = new HomePage(driver);
			ContactPage contactPage = homePage.gotoContactPage();
			//wait until page is loaded
			wait.until(ExpectedConditions.titleContains("Contact"));
			//assert with page title
			assertTrue(driver.getTitle().contains("Contact"));
		}
		
		@Test
		public void testNavigateHomeAboutContact() {
			//load web page
			driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumeg_pomm\\src\\main\\resources\\Home.html");
			//create home page instance
			HomePage homePage = new HomePage(driver);
			AboutPage aboutPage = homePage.gotoAboutPage();
			wait.until(ExpectedConditions.titleContains("About"));
			
			ContactPage contactPage = homePage.gotoContactPage();
			wait.until(ExpectedConditions.titleContains("Contact"));
			//assert with page title
			assertTrue(driver.getTitle().contains("Contact"));

		}
		
		static Stream<Arguments> getContactFormData(){
			//invoke ExcelRedUtils method
			Stream<Arguments> contactdata = ExcelReadUtils.readContactFormData();		
			return contactdata;
		}
		
		@ParameterizedTest
		@MethodSource("getContactFormData")
		public void checkContactForm(String name, String email, String details) {
			try {
			driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumeg_pomm\\src\\main\\resources\\Home.html");
			//create home page instance
			HomePage homePage = new HomePage(driver);
			ContactPage contactPage = homePage.gotoContactPage();
			//wait until page is loaded
			wait.until(ExpectedConditions.titleContains("Contact"));
			
			contactPage.fillContactForm(name,email,details);
			Thread.sleep(2000);
			String message = contactPage.checkSubmission();
			//assert with page title
			assertTrue(message.contains("Mail Sent Successfully"));
			}
			catch(Exception e) {e.printStackTrace();}
		}
		
		@AfterAll
		public static void tearDown() {
			if (driver != null) {
			driver.quit();}
		}
		
		
		
		
	}


