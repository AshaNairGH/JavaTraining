package eg.cucumber.bdd;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearchSteps {
	WebDriver driver;

	@Given("I am on the Product search page")
	public void i_am_on_the_product_search_page() {
		// set system property to chrome driver path
		// create web driver
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(chromeOptions);

		driver.get(
				"file:///C:\\Users\\Administrator\\eclipse-workspace\\eg.cucumber.bdd\\src\\test\\resources\\ProductSearch.html");
	}

	@When("I search for {string}")
	public void i_search_for(String product) {
		// locate text box
		WebElement searchBox = driver.findElement(By.id("searchInput"));

		// enter search product to above text box
		searchBox.sendKeys(product);

		// <button id="search" onclick="searchProducts()">Search</button>
		// locate Search button and click
		//driver.findElement(By.id("search")).click();
		driver.findElement(By.xpath("/html/body/div[1]/button")).click();
	}

	@Then("I should see search results related to {string}")
	public void i_should_see_search_results_related_to(String result) {
		try {
			Thread.sleep(1000);

			// locate result
			WebElement resultDiv = driver.findElement(By.id("results"));
			String actualresult = resultDiv.getText();

			// verify result text
			assertTrue(actualresult.contains(result));

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
