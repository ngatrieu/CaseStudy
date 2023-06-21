package StepDefinition;

import Utilities.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Pages.*;

public class UploadStepDef {
    UploadPage uploadPage;
    TestContext testContext;

    public UploadStepDef(TestContext context) {
        testContext = context;
        uploadPage = testContext.getPageObjectManager().getUploadPage();
    }

    @Given ("User choose a file with file extension {string} to upload")
    public void userChooseAFileWithFileExt(String fileExt) throws Exception {
        String filePath = uploadPage.setTxtChooseFile(fileExt);
//        uploadPage.verifyTxtChooseFile(filePath);
    }
    @When ("User submit file with {string} on Accept Terms Of Service checkbox")
    public void setAcceptTermsOfServiceCheckbox(String status) throws Exception {
        uploadPage.setAcceptTerms(status);
        uploadPage.clickSubmitButton();
    }
    @Then ("User should see the message displays as {string}")
    public void verifyMessageDisplays(String message) throws Exception {
        uploadPage.verifylblResultMessage(message);
    }

}
