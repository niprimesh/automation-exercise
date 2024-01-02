package com.automationexercise.steps;

import com.automationexercise.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Register {
    @And("I send name {string} and email {string} to signup")
    public void iSendNameAndEmailToSignup(String name, String email) {
        new SignupLoginPage().sendTextToSignupFields(name, email);
    }

    @Then("I should see text {string}")
    public void iShouldSeeText(String text) {
        new SignupLoginPage().getTextFromLoginPage(text);
    }

    @And("I fill all details in signup page {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void iFillAllDetailsInSignupPage(String title, String pass, String day, String month,
                                            String year, String fName, String lName, String add1, String add2,
                                            String country, String state, String city, String zipcode, String pNumber) {
        new RegisterPage().sendDataToSignupForm(title, pass, day, month, year, fName, lName, add1, add2, country, state, city, zipcode, pNumber);
    }

    @And("I click on news letter subscription check box")
    public void iClickOnNewsLetterSubscriptionCheckBox() {
        new RegisterPage().clickOnSignUpNewLetterCheckBox();
    }

    @And("I click on special offers check box")
    public void iClickOnSpecialOffersCheckBox() {
        new RegisterPage().clickOnReceiveSpecialOfferCheckBox();
    }

    @And("I click on Create Account button")
    public void iClickOnCreateAccountButton() {
        new RegisterPage().clickOnAccountCreateButton();
    }

    @Then("I see account created message {string}")
    public void iSeeAccountCreatedMessage(String text) {
        new RegisterPage().getAccountCreatedMessage();
    }

    @And("I click on continue button")
    public void iClickOnContinueButton() {
        new RegisterPage().clickOnContinueButtonAfterAccountCreated();
    }

    @Then("I should see the text {string} {string}")
    public void iShouldSeeTheText(String text, String username) {
        new HomePage().getLoggedInAsUserNameText();
    }

    @Then("I should see the account deleted message {string}")
    public void iShouldSeeTheAccountDeletedMessage(String text) {
        new HomePage().getAccountDeletedMessage(text);
    }

    @And("I click on continue button after deleting account")
    public void iClickOnContinueButtonAfterDeletingAccount() {
        new HomePage().clickOnContinueButtonAfterDeletedAccount();
    }

    @And("I send name {string} to name field in signup")
    public void iSendNameToNameFieldInSignup(String name) {
        new SignupLoginPage().sendDataToNameFieldInSignUp(name);
    }

    @And("I send email {string} to email field in signup")
    public void iSendEmailToEmailFieldInSignup(String email) {
        new SignupLoginPage().sendDataToEmailFieldInSignup(email);
    }

    @And("I click on {string} button")
    public void iClickOnButton(String button) {
        new SignupLoginPage().clickOnLoginPageButton(button);
    }

    @Then("I should see error message {string}")
    public void iShouldSeeErrorMessage(String text) {
        new SignupLoginPage().getEmailAlreadyExistErrorMessage();
    }

    @When("I click on header menu option Signup {string}")
    public void iClickOnHeaderMenuOptionSignup(String option) {
        new HomePage().clickOnSignupLoginTabMenu(option);
    }

    @And("I click on header menu option Deleted Account {string}")
    public void iClickOnHeaderMenuOptionDeletedAccount(String option) {
        new HomePage().clickOnDeletedAccountTabMenu(option);
    }

    @Then("Verify error {string} is visible")
    public void verifyErrorIsVisible(String text) {
        new SignupLoginPage().getTextFromLoginPage(text);
    }

    @And("I should see the welcome text on shopping cart page {string}")
    public void iShouldSeeTheWelcomeTextOnShoppingCartPage(String text) {
        Assert.assertEquals(new ShoppingCartPage().getShoppingCartText(), text);
    }

    @And("I click on Proceed to Checkout button")
    public void iClickOnProceedToCheckoutButton() {
        new ShoppingCartPage().clickOnProceedToCheckoutButton();
    }

    @And("I click on register link in the checkout popup")
    public void iClickOnRegisterLinkInTheCheckoutPopup() {
        new ShoppingCartPage().clickOnRegisterLink();
    }

    @And("I should see the text on checkout page {string}")
    public void iShouldSeeTheTextOnCheckoutPage(String text) {
        Assert.assertEquals(new CheckoutPage().getTextFromCheckOutPage(text), text);
    }

    @And("I enter details into comment area {string}")
    public void iEnterDetailsIntoCommentArea(String text) {
        new CheckoutPage().sendCommentToCommentTextArea(text);
    }

    @And("I click on place order button")
    public void iClickOnPlaceOrderButton() {
        new PaymentPage().clickOnPlaceOrderButton();
    }

    @And("I enter payment details {string} {string} {string} {string} and {string}")
    public void iEnterPaymentDetailsAnd(String name, String cNumber, String cvv, String month, String year) {
        new PaymentPage().addCardDetails(name, cNumber, cvv, month, year);
    }

    @And("I click on Pay and Confirm Order button")
    public void iClickOnPayAndConfirmOrderButton() {
        new PaymentPage().clickOnPayAndConfirmButton();
    }

    @Then("I should see the order confirmation message {string}")
    public void iShouldSeeTheOrderConfirmationMessage(String text) {
        Assert.assertEquals(new PaymentPage().getOrderSuccessMessage(), text);
    }

    @Then("Verify that the delivery address is same address filled at the time registration of  {string}")
    public void verifyThatTheDeliveryAddressIsSameAddressFilledAtTheTimeRegistrationOf(String dAdd) {
        Assert.assertEquals(new CheckoutPage().getDeliveryAddress(),dAdd);
    }

    @Then("Verify that the billing address is same address filled at the time registration of account {string}")
    public void verifyThatTheBillingAddressIsSameAddressFilledAtTheTimeRegistrationOfAccount(String bAdd) {
        Assert.assertEquals(new CheckoutPage().getBillingAddress(),bAdd);
    }
}
