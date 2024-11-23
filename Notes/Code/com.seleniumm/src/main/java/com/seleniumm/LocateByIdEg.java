package com.seleniumm;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByIdEg {
public static void main(String[] args) throws Exception{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	
	driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumm\\src\\main\\resources\\LocateByIdEg.html");
	
	WebElement usernameField = driver.findElement(By.id("username"));
	
	usernameField.sendKeys("myusername");
	
	Thread.sleep(5000);
	
	driver.quit();
	
}
}
