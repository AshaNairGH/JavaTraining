package com.seleniumm;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocateByLinkTextEg {
public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumm\\src\\main\\resources\\LocateByLinkTextEg.html");
		
		//wait until webpage loaded successfully
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement link1 =  driver.findElement(By.linkText("Visit Example"));
		File screenshot1 =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot1, new File("./screenshot1.png"));
		
		link1.click();
		
		Thread.sleep(3000);
		System.out.println("Title : "+driver.getTitle());
		File screenshot2 =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot2, new File("./screenshot2.png"));
		
		WebElement infolink =  driver.findElement(By.partialLinkText("information"));
		infolink.click();
		Thread.sleep(3000);
		File screenshot3 =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot3, new File("./screenshot3.png"));
		
		System.out.println("Next page title : "+driver.getTitle());
		
		Thread.sleep(5000);
		driver.quit();
}
}
