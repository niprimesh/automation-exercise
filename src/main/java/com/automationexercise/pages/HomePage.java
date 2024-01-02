package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li")
    List<WebElement> headerMenu;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement signupMenuOption;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Delete Account']")
    WebElement deletedAccountMenuOption;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutMenuOption;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Contact us']")
    WebElement contactUsMenuOption;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Home')]")
    WebElement homeMenuOption;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Test Cases']")
    WebElement testCasesMenuOption;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Cart']")
    WebElement cartMenuOption;

    @CacheLookup
    @FindBy(xpath = "//a[@href='/products']")
    WebElement productMenuOption;

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Account Deleted!']")
    WebElement accountDeletedMessage;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueButtonAfterAccountDeletedMessage;

    @CacheLookup
    @FindBy(xpath = "//li[10]//a[1]")
    WebElement loggedInAsUserName;

    @CacheLookup
    @FindBy (xpath = "//h2[normalize-space()='Subscription']")
    WebElement subscriptionText;

    @CacheLookup
    @FindBy (xpath = "//input[@id='susbscribe_email']")
    WebElement subscriptionEmailField;

    @CacheLookup
    @FindBy (xpath = "//i[@class='fa fa-arrow-circle-o-right']")
    WebElement subscriptionArrowButton;

    @CacheLookup
    @FindBy (xpath = "//div[@class='alert-success alert']")
    WebElement subscriptionSuccessMessage;

    @CacheLookup
    @FindBy (xpath = "//h2[normalize-space()='recommended items']")
    WebElement recommendedItemsText;

    @CacheLookup
    @FindBy (xpath = "//div[@id = 'recommended-item-carousel']//div[@class = 'productinfo text-center']/p")
    List<WebElement> recommendedItemsProductsList;

    @CacheLookup
    @FindBy (xpath = "//i[@class='fa fa-angle-up']")
    WebElement bottomRightArrowButton;

    @CacheLookup
    @FindBy (xpath = "//div[@class='item active']//h2[contains(text(),'Full-Fledged practice website for Automation Engin')]")
    WebElement fullFledgedText;

    public void clickOnHeaderMenu(String option) {
        for (WebElement menuList : headerMenu) {
            System.out.println(menuList.getText());
            if (menuList.getText().equalsIgnoreCase(option)) {
                menuList.click();
            }
            log.info("Clicking on header menu option : " + headerMenu.toString());
            break;
        }
    }

    public String getCurrentURL() {
        waitUntilVisibilityOfElementLocated(By.xpath("//h2[normalize-space()='Brands']"), 5);
        log.info("Getting Home Page URL : ");
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public void clickOnSignupLoginTabMenu(String option) {
        log.info("Clicking on header option Signup/Login : " + signupMenuOption.toString());
        clickOnElement(signupMenuOption);
    }

    public void clickOnDeletedAccountTabMenu(String option) {
        log.info("Clicking on header option Delete Account : " + deletedAccountMenuOption.toString());
        clickOnElement(deletedAccountMenuOption);
    }

    public void clickOnlogoutTabMenu(String option) {
        log.info("Clicking on header option Logout : " + logoutMenuOption.toString());
        clickOnElement(logoutMenuOption);
    }

    public void clickOnContactUsTabMenu(String option) {
        log.info("Clicking on header option Contact Us : " + contactUsMenuOption.toString());
        clickOnElement(contactUsMenuOption);
    }

    public void clickHomeTabMenu(String option) {
        log.info("Clicking on header option Home : " + homeMenuOption.toString());
        clickOnElement(homeMenuOption);
    }

    public void clickTestCasesTabMenu(String option) {
        log.info("Clicking on header option Home : " + testCasesMenuOption.toString());
        clickOnElement(testCasesMenuOption);
    }

    public void clickProductTabMenu(String option) {
        log.info("Clicking on header option Product : " + productMenuOption.toString());
        clickOnElement(productMenuOption);
    }

    public void clickOnCartTabMenu(String option) {
        log.info("Clicking on cart option : " + cartMenuOption.toString());
        clickOnElement(cartMenuOption);
    }

    public void getAccountDeletedMessage(String text) {
        log.info("Getting account deleted text : " + accountDeletedMessage.toString());
        getTextFromElement(accountDeletedMessage);
    }


    public void clickOnContinueButtonAfterDeletedAccount() {
        clickOnElement(continueButtonAfterAccountDeletedMessage);
        log.info("Clicking on continue button after deleting account : " + continueButtonAfterAccountDeletedMessage.toString());
    }

    public void getLoggedInAsUserNameText() {
        log.info("Getting text from login page : " + loggedInAsUserName.toString());
        getTextFromElement(loggedInAsUserName);
    }

    public void scrollDownToSubscription(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView",subscriptionText);
        log.info("Scrolling down to subscription");
    }

    public String getSubscriptionText() {
        log.info("Getting Subscription text : " + subscriptionText.toString());
        return getTextFromElement(subscriptionText);
    }

    public void sendDataToSubscriptionEmail(String email) {
        sendTextToElement(subscriptionEmailField, email);
        log.info("Sending email to subscription email field : " + subscriptionEmailField.toString());
    }

    public void clickOnArrowToSubscribe() {
        clickOnElement(subscriptionArrowButton);
        log.info("Clicking on subscription arrow button : " + subscriptionArrowButton.toString());
    }

    public String getSubscriptionMessage() {
        log.info("Getting subscription success message : " + subscriptionSuccessMessage.toString());
        return getTextFromElement(subscriptionSuccessMessage);
    }

    public void scrollDownToRecommendedItems(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", recommendedItemsText);
        log.info("Scroll down to the recommended items");
    }
    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,0)", "");
        log.info("Scroll up to (0,0)");
    }
    public String getRecommendedItemText() {
        log.info("Getting recommended items text : " + recommendedItemsText.toString());
        return getTextFromElement(recommendedItemsText);
    }

    public void clickAddToCartOnRecommendedItems(String pName){
        for (WebElement pList : recommendedItemsProductsList) {
            if(pList.getText().equalsIgnoreCase(pName)) {
                driver.findElement(with(By.xpath("//a[@class='btn btn-default add-to-cart']")).below(pList)).click();
                //driver.findElement(By.xpath("//a[@class='btn btn-default add-to-cart']")).click();
                log.info("Click on " + pName + " Add to Cart button : " + pList.toString());
                break;
            }
        }
    }
    public void clickOnBottomRightArrowButton() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", bottomRightArrowButton);
        log.info("Clicking on bottom right corner arrow button : " + bottomRightArrowButton.toString());
    }

    public String getFullFledgedText() {
        log.info("Getting full fledged text from top of the page : " + fullFledgedText.toString());
        return getTextFromElement(fullFledgedText);
    }

}
