package com.seleniumm;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByCSSEg {
public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumm\\src\\main\\resources\\LocateByCSSEg.html");
		
		//css selector by class
		//WebElement element = driver.findElement(By.cssSelector(".input-field"));
		
		//No such element Exception		
		//css selector by by
		//WebElement element = driver.findElement(By.cssSelector("#some-id"));
		
		//css selector by by
		//WebElement element = driver.findElement(By.cssSelector("input#some-id"));
		
		//WebElement element = driver.findElement(By.cssSelector("input[type='password']"));
		
		WebElement element = driver.findElement(By.cssSelector("form input"));
		element.sendKeys("somepassword");
		
		Thread.sleep(6000);
		System.out.println(element.getAttribute("value"));
		
		List<WebElement> elements = driver.findElements(By.cssSelector("input#some-id, .input-field"));
		elements.stream().forEach((e)->{System.out.println("--->"+e.getAttribute("type"));});
		
		WebElement elementa = driver.findElement(By.cssSelector("input#some-id.input-field"));
		System.out.println(elementa.getTagName()+" " +elementa.getAttribute("type"));
		Thread.sleep(6000);
		
		driver.quit();
}
}
