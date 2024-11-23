package com.seleniumm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByTagandMultipleElementsEg {
public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumm\\src\\main\\resources\\LocateByNameEg.html");

		//WebElement element = driver.findElement(By.tagName("input"));
		//element.sendKeys("sometext");
		//System.out.println(element.getAttribute("name"));
		
		List<WebElement> elements = driver.findElements(By.tagName("input"));
		for(WebElement element : elements)
		{
			element.sendKeys("some text here");
			System.out.println(element.getAttribute("name"));
		}
		
		
		
		
		Thread.sleep(8000);
		driver.quit();
		

}
}
