package com.seleniumm;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertConfirmPopupEg {

	public static void main(String[] args) {
		try {
			// chrome driver path
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

			// Create an instance of driver
			WebDriver driver = new ChromeDriver();

			// Load web page under Test
			driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumm\\src\\main\\resources\\AlertConfirmPopupEg.html");

			//test alert
			testAlert(driver);
			
			//test confirm
			testConfirm(driver);
			
			//test prompt

			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

private static void testAlert(WebDriver driver) throws InterruptedException{
	WebElement alertButton = driver.findElement(
			By.xpath("//button[text()='Show Alert']"));

	alertButton.click();

	Thread.sleep(2000);
	Alert alert = driver.switchTo().alert();
	System.out.println(alert.getText());
	alert.accept();

	Thread.sleep(2000);

}

private static void testConfirm(WebDriver driver) throws InterruptedException{
	WebElement alertButton = driver.findElement(
			By.xpath("//button[text()='Show Confirm']"));

	alertButton.click();

	Thread.sleep(2000);
	Alert alert = driver.switchTo().alert();
	System.out.println(alert.getText());
	alert.accept();

	Thread.sleep(2000);

}

private static void testPrompt(WebDriver driver) throws InterruptedException{
	WebElement promptButton = driver.findElement(By.id("prompt"));
	promptButton.click();
	Thread.sleep(2000);
	
	Alert alert = driver.switchTo().alert();
	System.out.println(alert.getText());
	alert.sendKeys("somename");
	Thread.sleep(2000);
	alert.accept();
	Thread.sleep(2000);
}

}