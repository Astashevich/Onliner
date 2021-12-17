package by.onliner.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/***
 * Runner is used to give a communication between feature files and steps files
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "by/onliner/cucumber",
        tags = "@SmokeTest")
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
