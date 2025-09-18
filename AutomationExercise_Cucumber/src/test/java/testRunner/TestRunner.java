package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    //features = {"src/test/resources/features/"},
	//features= {"src/test/resources/features/Login.feature"},
	//features= {"src/test/resources/features/RegisterUsingDataTable.feature"},
	features= {"src/test/resources/features/LoginScenarioOutline.feature"},
    glue = {"stepDefinitions", "hooks"},
    plugin = {
        "pretty", "html:reports/myreport.html"
        //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
    },
    monochrome = true, // to avoid junk character in console output
   // dryRun = true,    // just verify the scenarios and it's corresponding steps are mapping. Actual execution will not happen
    dryRun=false, //mapping between scenario steps and definitions
    publish = true    // To publish report in cucumber server/ If u want to share the cucumber report 
    //tags="@Sanity"
)
public class TestRunner {
    // No code needed here; JUnit will run based on annotations
}