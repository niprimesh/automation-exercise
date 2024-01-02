package com.automationexercise.steps;

import com.automationexercise.pages.ContactUsPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.PaymentPage;
import com.automationexercise.pages.TestCasesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Additional {


    @When("I click on header menu option Contact us {string}")
    public void iClickOnHeaderMenuOptionContactUs(String option) {
        new HomePage().clickOnContactUsTabMenu(option);
    }

    @Then("I should see welcome text on contact us page {string}")
    public void iShouldSeeWelcomeTextOnContactUsPage(String text) {
        Assert.assertEquals(new ContactUsPage().getTextToVerifyContactUs(), text);
    }

    @And("I enter {string} name to name field")
    public void iEnterNameToNameField(String name) {
        new ContactUsPage().enterName(name);
    }

    @And("I enter {string} email to email field")
    public void iEnterEmailToEmailField(String email) {
        new ContactUsPage().enterEmail(email);
    }

    @And("I enter {string} subject to subject field")
    public void iEnterSubjectToSubjectField(String subject) {
        new ContactUsPage().enterSubject(subject);
    }

    @And("I enter {string} message to message field")
    public void iEnterMessageToMessageField(String message) {
        new ContactUsPage().enterMessage(message);
    }

    @And("I upload file")
    public void iUploadFile() {
        new ContactUsPage().uploadFile();
    }

    @And("I click on submit button")
    public void iClickOnSubmitButton() {
        new ContactUsPage().clickOnSubmitButton();
    }

    @And("I click on ok button popup")
    public void iClickOnOkButtonPopup() {
        new ContactUsPage().acceptPopupMessage();
    }

    @Then("I should see the success message {string}")
    public void iShouldSeeTheSuccessMessage(String text) {
        Assert.assertEquals(new ContactUsPage().getDetailsSubmittedMessage(), text);
    }

    @And("I click on header menu option Home {string}")
    public void iClickOnHeaderMenuOptionHome(String option) {
        new HomePage().clickHomeTabMenu(option);
    }

    @Then("I am on text cases page and verify the test-cases URL {string}")
    public void iAmOnTextCasesPageAndVerifyTheTestCasesURL(String text) {
        Assert.assertEquals(new TestCasesPage().getCurrentURL(), text);
    }

    @When("I click on header menu option Test cases {string}")
    public void iClickOnHeaderMenuOptionTestCases(String option) {
        new HomePage().clickTestCasesTabMenu(option);
    }

    @When("I scroll down to subscription")
    public void iScrollDownToSubscription() {
        new HomePage().scrollDownToSubscription();
    }

    @Then("Verify the text {string}")
    public void verifyTheText(String subText) {
        Assert.assertEquals(new HomePage().getSubscriptionText(), subText);
    }

    @And("I enter email address in input {string}")
    public void iEnterEmailAddressInInput(String email) {
        new HomePage().sendDataToSubscriptionEmail(email);
    }

    @And("I click on arrow button")
    public void iClickOnArrowButton() {
        new HomePage().clickOnArrowToSubscribe();
    }

    @Then("Verify the success message {string}")
    public void verifyTheSuccessMessage(String text) {
        Assert.assertEquals(new HomePage().getSubscriptionMessage(), text);
    }

    @And("I click on header menu option Cart {string}")
    public void iClickOnHeaderMenuOptionCart(String option) {
        new HomePage().clickOnCartTabMenu(option);
    }

    @And("I Click Download Invoice button")
    public void iClickDownloadInvoiceButton() {
        new PaymentPage().clickOnDownloadInvoiceButton();
    }

    @And("Click Continue button")
    public void clickContinueButton() {
        new PaymentPage().clickOnContinueSAfterOrderPlaced();
    }

    @And("I Click on arrow at bottom right side to move upward")
    public void iClickOnArrowAtBottomRightSideToMoveUpward() {
        new HomePage().clickOnBottomRightArrowButton();
    }

    @Then("Verify that page is scrolled up and {string} text is visible on screen")
    public void verifyThatPageIsScrolledUpAndTextIsVisibleOnScreen(String text) {
        Assert.assertEquals(new HomePage().getFullFledgedText(), text);
    }


    @And("Scroll up page to top")
    public void scrollUpPageToTop() {
        new HomePage().scrollUp();
    }
}
