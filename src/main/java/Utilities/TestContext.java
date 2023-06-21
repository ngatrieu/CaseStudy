package Utilities;

import Lib.DriverManager;
import Lib.PageObjectManager;

public class TestContext {
    private final DriverManager driverManager;
    private final PageObjectManager pageObjectManager;

    public TestContext() {
        driverManager = new DriverManager();
        pageObjectManager = new PageObjectManager(driverManager.getDriver());
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }
}
