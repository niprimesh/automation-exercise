package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends Utility {
    private static final Logger log = LogManager.getLogger(ContactUsPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Get In Touch']")
    WebElement getInTouchText;

    @CacheLookup
    @FindBy(name = "name")
    WebElement name;

    @CacheLookup
    @FindBy(name = "email")
    WebElement email;

    @CacheLookup
    @FindBy(name = "subject")
    WebElement subject;

    @CacheLookup
    @FindBy(name = "message")
    WebElement message;

    @CacheLookup
    @FindBy(name = "upload_file")
    WebElement uploadFile;

    @CacheLookup
    @FindBy(name = "submit")
    WebElement submitButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='status alert alert-success']")
    WebElement successTextAfterSubmitForm;


    public String getTextToVerifyContactUs() {
        log.info("Getting text Contact us page" + getInTouchText.toString());
        return getTextFromElement(getInTouchText);
    }

    public void enterName(String name) {
        sendTextToElement(this.name, name);
        log.info("Sending name to name field:" + name);
    }

    public void enterEmail(String email) {
        sendTextToElement(this.email, email);
        log.info("Sending email address to email field:" + email);
    }

    public void enterSubject(String subject) {
        sendTextToElement(this.subject, subject);
        log.info("Sending subject to subject field:" + subject);
    }

    public void enterMessage(String msg) {
        sendTextToElement(message, msg);
        log.info("Sending message to message field:" + message.toString());
    }

    public void uploadFile() {
        uploadFile.sendKeys("D:/homework.txt");
        log.info("Uploading file :" + uploadFile.toString());
    }

    public void clickOnSubmitButton(){
        WebElement element = submitButton;
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        log.info("Clicking on submit button: " + submitButton.toString());
    }

    public void acceptPopupMessage(){
        switchToAlert();
        acceptAlert();
        log.info("Accepting the alert : ");
    }
    public String getDetailsSubmittedMessage() {
        log.info("Getting detailed success message : " + successTextAfterSubmitForm.toString());
        return getTextFromElement(successTextAfterSubmitForm);
    }

}
