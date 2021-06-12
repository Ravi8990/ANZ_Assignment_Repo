
package com.anz.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber-reports/CucumberTestReport.json",
		"html:target/cucumber-reports/cucumber.html" }, features = "src/test/resources/features", 
		glue = {"com.anz.stepdefinitions"}, 
		//tags = {"@HomeLoan01"},
		monochrome = true)

public class Mainrunner {

}
