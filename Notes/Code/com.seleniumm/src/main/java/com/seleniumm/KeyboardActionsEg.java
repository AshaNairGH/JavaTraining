package com.seleniumm;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyboardActionsEg {
public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumm\\src\\main\\resources\\KeyboardActionsEg.html");
		
		WebElement inputField = driver.findElement(By.id("inputField"));
		inputField.sendKeys("sometext here!");
		
		
		inputField.sendKeys(Keys.BACK_SPACE);
		inputField.sendKeys(Keys.CONTROL+""+"A");
		
		System.out.println(inputField.getAttribute("value"));
		
		inputField.sendKeys(Keys.TAB);
		driver.findElement(By.id("submitButton")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.id("output")).getText());
		
		Thread.sleep(5000);
		driver.quit();
		
}
}
