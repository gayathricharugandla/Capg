package Com.Gmail.Users.Runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features=".\\src\\test\\java\\Com\\Gmail\\Users\\Features\\Login2.feature",
		glue="Com.Gmail.Users.StepDef",
		tags="@TC4",
		plugin= {"pretty","html:Reports/cucumber-reports.html","json:Reports/cucumber-reports.json","junit:Reports/cucumber-reports.xml"}
		)
public class TestRunner2 extends AbstractTestNGCucumberTests{
}
