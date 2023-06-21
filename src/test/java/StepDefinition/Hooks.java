package StepDefinition;

import Utilities.TestContext;
import Lib.FileReaderLib;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    TestContext testContext;
    WebDriver webDriver;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @Before
    public void setup() {
        webDriver = testContext.getDriverManager().getDriver();
        webDriver.get(FileReaderLib.getInstance().getConfigFileReader().getUrl());
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            String screenshotName = scenario.getName();//.replaceAll("", "_");
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot)testContext.getDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "img/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        testContext.getDriverManager().closeDriver();
    }
}
