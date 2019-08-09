package stepdefinition;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

	@CucumberOptions(features = "Resources", glue = "stepdefinition", monochrome = true, plugin = {
			"pretty", "json:target/CaseStudy.json" } , tags = {"@Case4"}, dryRun=false)
	public class Runner extends AbstractTestNGCucumberTests {

}
