package com.mobiletestautomation.helpers;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportHelper {

    // Configure cucumber report properties
    public static void generateTestReport(){
        File reportOutDirecotry = new File("target");

        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber.json");

        String projectName = "MobileTestAutomation Project";
        Configuration configuration = new Configuration(reportOutDirecotry, projectName);
        configuration.addClassifications("Platform", System.getProperty("os.name"));
        configuration.addClassifications("BRANCH","RELEASE");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}