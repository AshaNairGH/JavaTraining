package com.seleniumm;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HTMLFormEg {
public static void main(String[] args) throws Exception{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("file:///C:\\Users\\Administrator\\eclipse-workspace\\com.seleniumm\\src\\main\\resources\\HTMLFormEg.html");
		
		WebElement usernameField = driver.findElement(By.id("username"));
		WebElement maleRadio = driver.findElement(By.id("male"));
		WebElement FemaleRadio = driver.findElement(By.id("female"));
		WebElement subCheckbox = driver.findElement(By.id("subscribe"));
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		WebElement submitButton = driver.findElement(By.id("submitBtn"));
		WebElement message = driver.findElement(By.id("message"));

		usernameField.sendKeys("someusername");
		maleRadio.click();
		
		String str = maleRadio.isSelected()? "Male":"Female";
		System.out.println("Radio selected: "+str);
		
		subCheckbox.click();
		System.out.println("Subscribed: "+subCheckbox.isSelected());
		
		Select dropdownSelect = new Select(dropdown);
		
		dropdownSelect.selectByValue("option2");
		
		System.out.println(dropdownSelect.getFirstSelectedOption().getText());
		
		submitButton.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.quit();
}
}
