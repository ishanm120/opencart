package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"stepdefinitions"},
        tags = "@Test and @runBackground",
        plugin = {"pretty", "html:target/cucumber-reports"}

)


public class TestRunner extends AbstractTestNGCucumberTests {


}


