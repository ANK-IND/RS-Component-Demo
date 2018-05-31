package com.Runner;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/Users/nirmalkumar/Documents/RSComponents/src/main/java/com/Features",
        glue = "com.StepDefinitions",
        format = "html:Output",
        plugin = "com.cucumber.listener.ExtentCucumberFormatter:output/report.html",
        tags = "@Login",//Please provide tags for Running Selected Scenario
        monochrome = true,
        dryRun = false,
        strict = true)


public class RSTestRunner {

    @BeforeClass
    public static void setup() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("output/myreport.html");
    }

    @AfterClass
    public static void teardown() {
        String path = System.getProperty("user.dir");
        System.out.println(path);
        Reporter.loadXMLConfig(new File(path + "/src/main/java/com/ExtentReport/ExtentConfig.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Mac OSX");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }


}
