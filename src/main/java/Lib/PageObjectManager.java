package Lib;

import org.openqa.selenium.WebDriver;
import Pages.UploadPage;

public class PageObjectManager {
    private final WebDriver webDriver;
    private UploadPage uploadPage;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public UploadPage getUploadPage() {
        return (uploadPage == null) ? uploadPage = new UploadPage(webDriver) : uploadPage;
    }
}
