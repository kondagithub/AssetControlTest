package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
//		dryRun = true,
		features = { ".//src//test//resources//features//" },
		glue = {"stepdefinitions"},
		monochrome = true,
		plugin = {	"pretty","html:target/cucumber-reports"  }	
)
public class TestRunner {

}
