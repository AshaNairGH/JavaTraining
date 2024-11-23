package com.seleniumm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocateByClassEg {
public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumm\\src\\main\\resources\\LocateByClassEg.html");
		
		//wait until webpage loaded successfully
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement button =  wait.until(ExpectedConditions.elementToBeClickable(By.className("button")));
		
		//click button
		button.click();
		
		WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("message")));
		System.out.println("Message: "+ message.getText());
		
		Thread.sleep(1000);
		
		driver.quit();
		
}
}
