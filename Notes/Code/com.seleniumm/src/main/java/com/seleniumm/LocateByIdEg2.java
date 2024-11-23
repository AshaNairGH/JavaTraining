package com.seleniumm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByIdEg2 {
	public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumm\\src\\main\\resources\\LocateByIdEg2.html");
		
		WebElement tbutton = driver.findElement(By.id("testButton"));
		Thread.sleep(3000);
		tbutton.click();
		
		Thread.sleep(2000);
		
		WebElement messageField = driver.findElement(By.id("message"));
		String umessage = messageField.getText();
		
		System.out.println("Updated Message: "+umessage);
		
		Thread.sleep(10000);
		
		driver.quit();
	}
}
