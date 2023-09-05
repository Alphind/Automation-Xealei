package org.alphind.xealei.stepdefinition;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

	@Before
	public void beforeScenario() throws Exception {

		browserType("Chrome");
		loadUrl(readData("TestDatas", "Environments", 2, 1));
		maximize();
		implicitWaitBySeconds(10);
	}

	@After 
	public void screenShot(Scenario scenario) throws Exception {

		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}

		else {
			waitForPageLoad();
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
	
	@After(order = 1)
	public void afterScenario() {
		
		waitForPageLoad();
		sleep(1000);
		//close();
	}

}
