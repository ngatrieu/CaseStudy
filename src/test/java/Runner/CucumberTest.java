package Runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"pretty",
                "html:test-output",
                "json:target/cucumber-report/report.json",
                "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        glue = {"StepDefinition"})
public class CucumberTest {
}
