package com.seleniumm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstExample {
	public static void main(String[] args) throws Exception{
		
		//chrome driver path
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
			
		//crete an instance or chrome driver
		WebDriver driver = new ChromeDriver();
		
		//send get request for sample webpage
		driver.get("http://www.example.com");
		
		//Retrieve title of the webpage
		String title = driver.getTitle();
		System.out.println("Page title: "+title);
		
		Thread.sleep(3000);
		driver.quit();
	}

}
