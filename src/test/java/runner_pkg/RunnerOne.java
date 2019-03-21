package runner_pkg;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="D:\\Automation_workspace\\cucumber_maven_selenium\\src\\test\\java\\featurePkg\\featureOne.feature",
glue={"stepDefinationPkg"},

plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
		"junit:target/cucumber-reports/Cucumber.xml",
"html:target/cucumber-reports"},
monochrome = true


		)
public class RunnerOne {

}
