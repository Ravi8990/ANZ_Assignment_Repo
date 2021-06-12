package com.anz.stepdefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import com.anz.generic.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends DriverFactory {

	@Before()
	public void hooKed() {
		driver = getDriver();
	}

	@AfterStep()
	public void eachstepscreenshot(Scenario scenario) {

		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, "image/png");

	}

	@After()

	public void failurescreenshot(Scenario scenariofail) {
		try {
			if (scenariofail.isFailed()) {

				final byte[] Fail = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenariofail.embed(Fail, "image/png");

			}
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//new BaseLibrary().teardownbrowser();

	}
}
