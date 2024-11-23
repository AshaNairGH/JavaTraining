package com.seleniumm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActionsEg {
public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumm\\src\\main\\resources\\MouseActionsEg.html");
		
		Actions actions = new Actions(driver);
		WebElement clickButton = driver.findElement(By.id("clickButton"));

		//perform click
		//clickButton.click();
		actions.click(clickButton).perform();
		
		Thread.sleep(2000);
		
		WebElement hoverDiv = driver.findElement(By.id("hoverDiv"));
		
		//mousehover
		actions.moveToElement(hoverDiv).perform();
		Thread.sleep(3000);
				
		//double click
		WebElement doubleClickButton = driver.findElement(By.id("clickButton"));
		actions.doubleClick(doubleClickButton).perform();
		Thread.sleep(2000);
		
		//rightclick
		actions.contextClick(clickButton).perform();
		Thread.sleep(2000);
		
		WebElement dragDiv = driver.findElement(By.id("dragDiv"));
		WebElement dropArea = driver.findElement(By.id("dropArea"));
		
		//drag and drop
		actions.clickAndHold(dragDiv)
				.moveToElement(dropArea)
				.release()
				.perform();
		Thread.sleep(2000);
		driver.quit();

}
}
