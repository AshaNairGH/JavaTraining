package com.seleniumm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByNameEg {
public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumm\\src\\main\\resources\\LocateByNameEg.html");
		
		WebElement usernameField = driver.findElement(By.name("username"));
		
		usernameField.sendKeys("newUser");
		
		Thread.sleep(10000);
		
		driver.quit();
		
}
}
