package eg.cucumber.bdd;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true,
//plugin = {"pretty"}
plugin = {"html:target/cucumber-html-report", "json:target/cucumber-json-report.json"})
public class TestRunner {

}