package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class SignupLoginPage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New User Signup!']")
    WebElement newUserSignUpText;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement signupNameField;

    @CacheLookup
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement signupEmailField;

    @CacheLookup
    @FindBy (xpath = "//button[normalize-space()='Signup']")
    WebElement signupButton;

    @CacheLookup
    @FindBy (xpath = "//input[@data-qa='login-email']")
    WebElement loginEmailField;

    @CacheLookup
    @FindBy (xpath = "//input[@placeholder='Password']")
    WebElement loginPasswordField;

    @CacheLookup
    @FindBy (xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy (xpath = "//h2[normalize-space()='Login to your account']")
    WebElement loginToYourAccountText;

    @CacheLookup
    @FindBy (xpath = "//p[normalize-space()='Your email or password is incorrect!']")
    WebElement incorrectLoginCredentialMessage;

    @CacheLookup
    @FindBy (xpath = "//p[normalize-space()='Email Address already exist!']")
    WebElement emailAlreadyExistErrorMessage;


    public String getTextFromLoginPage(String text){
        if(text.equalsIgnoreCase("Login to your account")){
            log.info("Getting text as Login to your account : " + loginToYourAccountText.toString());
            return getTextFromElement(loginToYourAccountText);
        } else if (text.equalsIgnoreCase("New User Signup!")) {
            log.info("Getting text as New User Signup! : " + newUserSignUpText.toString());
            return getTextFromElement(newUserSignUpText);
        } else if (text.equalsIgnoreCase("Your email or password is incorrect!")) {
            log.info("Getting text for invalid credentials while login : " + incorrectLoginCredentialMessage.toString());
            return getTextFromElement(incorrectLoginCredentialMessage);
        } else {
            return "Text is not correct";
        }
    }

    public void sendTextToSignupFields(String name,String email){
        sendTextToElement(signupNameField,name);
        log.info("Sending the name text to signup field : " + signupEmailField.toString());
        sendTextToElement(signupEmailField, email+getRandomString(2)+"@gmail.com");
        log.info("Sending the email text to signup field : " + signupEmailField.toString());
    }

    public void sendDataToLoginFields(String email, String password){
        sendTextToElement(loginEmailField, email);
        log.info("Sending data to Email Address Field in Login : " + loginEmailField.toString());
        sendTextToElement(loginPasswordField, password);
        log.info("Sending data to Password Field in Login : " + loginPasswordField.toString());
    }

    public void clickOnLoginPageButton(String button){
        if (Objects.equals(button, "Login")){
            clickOnElement(loginButton);
            log.info("Clicking on Login button : " + loginButton.toString());
        } else if (Objects.equals(button, "Signup")) {
            clickOnElement(signupButton);
            log.info("Clicking on Signup button : " + signupButton.toString());
        } else {
            System.out.println("No button clicked");
        }
    }

    public void sendDataToNameFieldInSignUp(String name){
        sendTextToElement(signupNameField, name);
        log.info("Sending name to signup field : " +signupNameField.toString());
    }

    public void sendDataToEmailFieldInSignup(String email) {
        sendTextToElement(signupEmailField, email);
        log.info("Sending email to the email field : "+signupEmailField.toString());
    }

    public String getEmailAlreadyExistErrorMessage() {
        log.info("Getting email already exist error : "+emailAlreadyExistErrorMessage.toString());
        return getTextFromElement(emailAlreadyExistErrorMessage);
    }

    public String getCurrentURL(){
        log.info("Getting Login Page URL ");
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
}
