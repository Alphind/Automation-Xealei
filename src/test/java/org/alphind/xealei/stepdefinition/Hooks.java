/* Copyright (C) 2023  Alphind Solution Software Pvt. Ltd. - All Rights Reserved.

* created by Mohamed Razul

* reviewed by Hajira Begam

* You may use, distribute and modify this code for internal purpose,  however, distribution outside the organization     * is prohibited without prior and proper license agreement

*/

package org.alphind.xealei.stepdefinition;

import org.alphind.xealei.baseclass.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks extends BaseClass {
	

	@Before
	public void setUp() throws Exception {

		
	        	browserType();
	    		env();
	    		maximize();
	    		implicitWaitBySeconds(25);
	    		
	}

	@AfterStep
	public void ssAfterStep(Scenario scenario) {
	
		waitForPageLoad();
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
	}
	
	@After
	public void screenShot(Scenario scenario) throws Exception {

		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}	
	}
	
	
	@After(order = 1)
	public void tearDown() {
		
		waitForPageLoad();
		if(driver != null) {
			sleep(2000);
			quit();
		}
		
	}
	
//	@After(order = 2)
//	public void cleaningProcess() {
//		
//	/* cleanRecordFromDB(true, "xealeiqa", "", "");
//	 * cleanRecordFromDB(true, null, null, null);
//	 */

}
