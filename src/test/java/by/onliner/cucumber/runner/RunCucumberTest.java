package by.onliner.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "by/onliner/cucumber")
        //tags = "@foo, @bar")
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
