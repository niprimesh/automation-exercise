package com.automationexercise.steps;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.SignupLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Login {
    @When("I click on header menu option {string}")
    public void iClickOnHeaderMenuOption(String option) {
        new HomePage().clickOnHeaderMenu(option);
    }

    @Then("I should see the login page text {string}")
    public void iShouldSeeTheLoginPageText(String text) {
        Assert.assertEquals(new SignupLoginPage().getTextFromLoginPage(text),text);
    }

    @And("I enter {string} email and {string} password for login")
    public void iEnterEmailAndPasswordForLogin(String email, String password) {
        new SignupLoginPage().sendDataToLoginFields(email,password);
    }

    @And("I click on button {string}")
    public void iClickOnButton(String button) {
        new SignupLoginPage().clickOnLoginPageButton(button);
    }

    @Given("I am on homepage and verify the homepage URL")
    public void iAmOnHomepageAndVerifyTheHomepageURL() {
        Assert.assertEquals(new HomePage().getCurrentURL(), "https://automationexercise.com/");
    }

    @When("I click on header menu option signup {string}")
    public void iClickOnHeaderMenuOptionSignup(String option) {
        new HomePage().clickOnSignupLoginTabMenu(option);
    }


    @And("I click on header menu option logout {string}")
    public void iClickOnHeaderMenuOptionLogout(String option) {
        new HomePage().clickOnlogoutTabMenu(option);
    }

    @Then("Verify that user is navigated to login page")
    public void verifyThatUserIsNavigatedToLoginPage() {
        Assert.assertEquals(new SignupLoginPage().getCurrentURL(),"https://automationexercise.com/login");
    }
}
