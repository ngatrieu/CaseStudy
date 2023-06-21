package Lib;

import Enums.DriverType;
import Enums.EnvironmentType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManager {
    private WebDriver webDriver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;

    public DriverManager() {
        driverType = FileReaderLib.getInstance().getConfigFileReader().getBrowser();
        environmentType = FileReaderLib.getInstance().getConfigFileReader().getEnvironment();
    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case CHROME:
                ChromeOptions option=new ChromeOptions();
                option.setPageLoadStrategy(PageLoadStrategy.NONE);
                webDriver = new ChromeDriver(option);
                break;
        }
        long time = FileReaderLib.getInstance().getConfigFileReader().getTime();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));

        return webDriver;
    }

    private WebDriver createDriver() {
        switch (environmentType) {
            case LOCAL:
                webDriver = createLocalDriver();
                break;
        }
        return webDriver;
    }

    public WebDriver getDriver() {
        if (webDriver == null) webDriver = createDriver();
        return webDriver;
    }

    public void closeDriver() {
        webDriver.close();
        webDriver.quit();
    }
}
