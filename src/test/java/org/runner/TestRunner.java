package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.steps.Report;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\DELL\\eclipse-workspace\\Cucumbermarch\\src\\test\\resources",
dryRun=false,
glue="org.steps",
monochrome=true,
//plugin= {"html:C:\\Users\\DELL\\eclipse-workspace\\Cucumbermarch\\target"}
plugin= {"json:C:\\Users\\DELL\\eclipse-workspace\\Cucumbermarch\\target\\output.json"})

public class TestRunner {
@AfterClass
public static void report() {
	Report.report("C:\\Users\\DELL\\eclipse-workspace\\Cucumbermarch\\target\\output.json");
}
	
	
	

}
