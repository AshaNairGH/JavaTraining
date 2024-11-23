package stepdefinitions;

import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitions {
private int num1,num2, result;

	@Given("I have two numbers {int} and {int}")
	public void i_have_two_numbers(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	@When("I add them")
	public void i_add_them(){
		result = num1+num2;
	}
	
	@Then("the result should be {int}")
	public void the_result_should_be(int expectedresult) {
		assertEquals(expectedresult, result);
	}
	
}
