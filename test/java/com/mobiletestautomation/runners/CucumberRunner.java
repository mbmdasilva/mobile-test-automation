package com.mobiletestautomation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;

import static com.mobiletestautomation.helpers.ReportHelper.generateTestReport;

@CucumberOptions( strict = true, monochrome = true, features ="src/test/resources/features",
glue = "com.mobiletestautomation.steps", plugin = {"pretty", "json:target/cucumber.json"}, tags ={"@wip"})

public class CucumberRunner extends AbstractTestNGCucumberTests {
    //logger
    private static Logger logger = LoggerFactory.getLogger(CucumberRunner.class);

    //Generate cucumber reports
    @AfterSuite(alwaysRun = true)
    public void generateHTMLReports() {
        logger.info("Generating cucumber test run report");
        generateTestReport();
    }
}