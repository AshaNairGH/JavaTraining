package com.seleniumeg_pomm;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainTestAppJunit {
	
	private static WebDriver driver;
	private static WebDriverWait wait;
	
	@BeforeAll
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

		//create driver instance
		driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
		
		@Test
		public void checkContactForm() {
			try {
			driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumeg_pomm\\src\\main\\resources\\Home.html");
			//create home page instance
			HomePage homePage = new HomePage(driver);
			ContactPage contactPage = homePage.gotoContactPage();
			//wait until page is loaded
			wait.until(ExpectedConditions.titleContains("Contact"));
			
			contactPage.fillContactForm("abcd","abc@gmail.com","Messagesss");
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


