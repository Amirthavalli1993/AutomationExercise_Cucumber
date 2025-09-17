package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    glue = {"stepDefinitions", "hooks"},
    plugin = {
        "pretty",
        "html:reports/myreport.html",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
    },
    monochrome = true, // makes console output readable
    dryRun = false,    // mapping between scenario steps and definitions
    publish = true     // To publish report in cucumber server
)
public class TestRunner {
    // No code needed here; JUnit will run based on annotations
}