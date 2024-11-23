package eg.selenium.parallel;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;

public class ParallelSeleniumTest {

	@BeforeAll
	public static void met() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
	}

	@Test
	void testGoogle() {

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get("https://www.google.com");
		assertTrue(driver.getTitle().contains("Google"));
		driver.quit();
	}

	@Test
	void testBing() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.get("https://www.bing.com");
		assertTrue(driver.getTitle().contains("Bing"));
		driver.quit();
	}

	@Test
	void testYahoo() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(chromeOptions);
		
		driver.get("https://www.yahoo.com");
		assertTrue(driver.getTitle().contains("Yahoo"));
		driver.quit();
	}
}
