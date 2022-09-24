package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/",
        glue = "stepdefinitions",
        plugin = {"pretty", "json:target/allure-report/allure.json"},
        tags = "not @Ignore"
)
class TestRunnerTestNG extends AbstractTestNGCucumberTests {

}



