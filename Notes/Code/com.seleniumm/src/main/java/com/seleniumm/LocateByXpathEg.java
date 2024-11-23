package com.seleniumm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByXpathEg {
public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumm\\src\\main\\resources\\LocateByIdEg.html");
		
		WebElement element = driver.findElement(By.xpath("//input[@id='username']"));
		element.sendKeys("sometext");
		
		System.out.println(element.getAttribute("value"));
		
		//WebElement elementb = driver.findElement(By.xpath("//button[text()='Login']"));
		//WebElement elementb = driver.findElement(By.xpath("//button[contains(text(),'in')]"));
		WebElement elementb = driver.findElement(By.xpath("//button[starts-with(text(),'Log')]"));
		elementb.click();
		
		Thread.sleep(2000);
		
		driver.quit();
}
}
