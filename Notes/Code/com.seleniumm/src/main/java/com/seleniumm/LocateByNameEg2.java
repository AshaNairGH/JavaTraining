package com.seleniumm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocateByNameEg2 {
public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumm\\src\\main\\resources\\LocateByNameEg2.html");
		
		//wait until webpage loaded successfully
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//locate username
		WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))); 
		
		//enter test in username field
		usernameField.sendKeys("someuser");
				
		//locate age
		WebElement ageField = driver.findElement(By.name("age"));
		
		//enter age
		ageField.sendKeys(String.valueOf(35));
		
		//locate email
		WebElement emailField = driver.findElement(By.name("email"));
		
		//enter email
		emailField.sendKeys("abc@gmail.com");
		
		
		//set country
		WebElement countryDropdown = driver.findElement(By.name("country"));
		countryDropdown.sendKeys("Canada");
				
		//locate button
		WebElement submitButton = driver.findElement(By.id("submitButton"));
		
		//click button
		submitButton.click();
		
		//wait for message to be visible and get updated message text
		WebElement messageDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		System.out.println("Message: "+messageDiv.getText());
		
		Thread.sleep(10000);
		
		
}
}
