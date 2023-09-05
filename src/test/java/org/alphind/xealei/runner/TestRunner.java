package org.alphind.xealei.runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Features\\TC2_Suites.feature", 
glue = "org.alphind.xealei.stepdefinition",dryRun = false ,monochrome = true,
plugin = {"html:target/html.html",
		"junit:target/junit.xml",
		"json:target/json.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})



public class TestRunner  {
	

	
	
}
