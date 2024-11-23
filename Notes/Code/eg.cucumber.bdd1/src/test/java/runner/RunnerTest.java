package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true,
features = "src/test/resources/features/MathFeature.feature", 
glue = "stepdefinitions",
plugin = {"pretty"}
		)

public class RunnerTest {

}