package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

    @CucumberOptions(
            features = "src/main/resources/",
            glue = "stepdefinitions",
            plugin = {"pretty"/*, "json:target/cucumber-report/cucumber.json"*/},
            tags = "not @Ignore"
    )
    class TestRunnerTestNG extends AbstractTestNGCucumberTests {

    }



