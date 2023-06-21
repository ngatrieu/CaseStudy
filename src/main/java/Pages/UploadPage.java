package Pages;

import Lib.FileReaderLib;
import Utilities.Utils;
import Utilities.Wait;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadPage {

    Utils utils = new Utils();
    private final WebDriver webDriver;

    public UploadPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        Assert.assertTrue(defaultUploadPageIsDisplayed());
    }

    @FindBy(id = "uploadfile_0")
    private WebElement txtChooseFile;

    @FindBy(id = "terms")
    private WebElement chkTerms;

    @FindBy(id = "submitbutton")
    private WebElement btnSubmit;

    @FindBy(className = "demo")
    private WebElement lblResultMessage;

    public String setTxtChooseFile(String fileExt) throws IOException {
        String userDirectory = System.getProperty("user.dir");
        String strPath = userDirectory + "/src/test/resources/data/samples";
        Path path = Paths.get(strPath);
        String filePath = utils.findFilesWithExt(path, fileExt);
        System.out.println(filePath);
        txtChooseFile.sendKeys(filePath);
        System.out.println("xyz");
        return filePath;
    }

    private boolean defaultUploadPageIsDisplayed() {
        return (txtChooseFile.isDisplayed() && chkTerms.isDisplayed() && btnSubmit.isDisplayed());
    }

    public void clickSubmitButton(){
        btnSubmit.click();
    }

    public void setAcceptTerms(String status){
        switch (status) {
            case "check":
                if (!chkTerms.isSelected())
                {
                    chkTerms.click();
                }
                break;
            case "uncheck":
                if (chkTerms.isSelected())
                {
                    chkTerms.click();
                }
                break;
        }

    }

//    public void verifyTxtChooseFile(String strFilePath){
//        String fileName = utils.getFileNameFromPath(strFilePath);
//        System.out.println(fileName.toLowerCase().equals(txtChooseFile.getText().toLowerCase()));
//        Assert.assertTrue("Verify the file already selected",fileName.toLowerCase().equals(txtChooseFile.getText().toLowerCase()));
//    }

    public void verifylblResultMessage(String strMessage){
        long time = FileReaderLib.getInstance().getConfigFileReader().getTime();
        Wait.untilElementIsVisible(webDriver,lblResultMessage, time);
        Assert.assertTrue("Verify the file is uploaded successfully",strMessage.toLowerCase().equals(lblResultMessage.getText().toLowerCase().replaceAll("\n"," ")));
    }

}
