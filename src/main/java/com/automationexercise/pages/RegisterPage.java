package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Utility {
    private static final Logger log = LogManager.getLogger(RegisterPage.class.getName());

    @CacheLookup
    @FindBy(id = "id_gender1")
    WebElement titleForMrRadioButton;

    @CacheLookup
    @FindBy(id = "id_gender2")
    WebElement titleForMrsRadioButton;

    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "days")
    WebElement day;

    @CacheLookup
    @FindBy(id = "months")
    WebElement month;

    @CacheLookup
    @FindBy(id = "years")
    WebElement year;

    @CacheLookup
    @FindBy(id = "first_name")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "last_name")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "address1")
    WebElement address1;

    @CacheLookup
    @FindBy(id = "address2")
    WebElement address2;

    @CacheLookup
    @FindBy(id = "country")
    WebElement countryDropDown;

    @CacheLookup
    @FindBy(id = "state")
    WebElement state;

    @CacheLookup
    @FindBy(id = "city")
    WebElement city;

    @CacheLookup
    @FindBy(id = "zipcode")
    WebElement zipcode;

    @CacheLookup
    @FindBy(id = "mobile_number")
    WebElement mobileNumber;

    @CacheLookup
    @FindBy(xpath = "(//button[@type = 'submit'])[1]")
    WebElement createAccountButton;

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Account Created!']")
    WebElement accountCreatedMessage;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueButtonAfterAccountCreated;

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
    WebElement enterAccountInformationText;

    @CacheLookup
    @FindBy(xpath = "//input[@id='newsletter']")
    WebElement newsLetterCheckBox;

    @CacheLookup
    @FindBy(xpath = "//input[@id='optin']")
    WebElement specialOfferCheckBox;

    public void sendDataToSignupForm(String title, String password, String day, String month, String year, String fName, String lName, String add1, String add2, String country, String state, String city,
                                     String zipcode, String mobile) {
        if (title.equalsIgnoreCase("Mr")) {
            clickOnElement(titleForMrRadioButton);
            log.info("Selecting radio button Mr.");
        } else {
            clickOnElement(titleForMrsRadioButton);
            log.info("Selecting radio button Mrs.");
        }
        sendTextToElement(passwordField, password);
        log.info("Sending password to password field" + passwordField);
        selectByVisibleTextFromDropDown(this.day, day);
        log.info("Selecting day from Day dropdown in DOB" + day);
        selectByVisibleTextFromDropDown(this.month, month);
        log.info("Selecting month from Month dropdown in DOB" +month);
        selectByVisibleTextFromDropDown(this.year, year);
        log.info("Selecting year from Year dropdown in DOB" +year);
        sendTextToElement(firstName, fName);
        log.info("Sending firstname to First Name field" + firstName);
        sendTextToElement(lastName, lName);
        log.info("Sending lastname to Last Name field" +lName);
        sendTextToElement(address1, add1);
        log.info("Sending address1 to Address1 field" +add1);
        sendTextToElement(address2, add2);
        log.info("Sending address2 to Address2 field" +add2);
        selectByVisibleTextFromDropDown(countryDropDown, country);
        log.info("Selecting country from Country dropdown" +country);
        sendTextToElement(this.state, state);
        log.info("Sending state to State field" +state);
        sendTextToElement(this.city, city);
        log.info("Sending city to City field" +city);
        sendTextToElement(this.zipcode, zipcode);
        log.info("Sending zipcode to Zipcode field" +zipcode);
        sendTextToElement(mobileNumber, mobile);
        log.info("Sending mobilenumber to Mobile Number field" +mobileNumber);
    }

    public void clickOnAccountCreateButton(){
        clickOnElement(createAccountButton);
    }

    public void clickOnSignUpNewLetterCheckBox() {
        clickOnElement(newsLetterCheckBox);
        log.info("Clicking on News Letter Subscription Check Box : " + newsLetterCheckBox.toString());
    }

    public void clickOnReceiveSpecialOfferCheckBox() {
        clickOnElement(specialOfferCheckBox);
        log.info("Clicking on Receive Special Offer Check Box : " + specialOfferCheckBox.toString());
    }
    public String getEnterAccountInformationText() {
        log.info("Getting Enter Account Information text : " + enterAccountInformationText.toString());
        return getTextFromElement(enterAccountInformationText);
    }
    public String getAccountCreatedMessage() {
        log.info("Getting account created message : " + accountCreatedMessage.toString());
        return getTextFromElement(accountCreatedMessage);
    }

    public void clickOnContinueButtonAfterAccountCreated() {
        clickOnElement(continueButtonAfterAccountCreated);
        log.info("Clicking on continue button after account created : " + continueButtonAfterAccountCreated.toString());
    }
}
