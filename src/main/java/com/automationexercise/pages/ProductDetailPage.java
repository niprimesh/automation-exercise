package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends Utility {
    private static final Logger log = LogManager.getLogger(ProductDetailPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-details']/div[2]/div/h2")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-information']/p[1]")
    WebElement productCategory;

    @CacheLookup
    @FindBy(xpath = "//div[@class='product-information']/span/span")
    WebElement productPrice;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'product-information']/p[2]")
    WebElement productAvailability;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'product-information']/p[3]")
    WebElement productCondition;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'product-information']/p[4]")
    WebElement productBrand;

    @CacheLookup
    @FindBy(xpath = "//input[@id='quantity']")
    WebElement productQuantity;

    @CacheLookup
    @FindBy (xpath = "//button[normalize-space()='Add to cart']")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy (xpath = "//u[normalize-space()='View Cart']")
    WebElement viewCartLink;

    @CacheLookup
    @FindBy (id = "name")
    WebElement yourNameField;

    @CacheLookup
    @FindBy (id = "email")
    WebElement emailAddressField;

    @CacheLookup
    @FindBy (id = "review")
    WebElement addReviewField;

    @CacheLookup
    @FindBy (id = "button-review")
    WebElement reviewSubmitButton;

    @CacheLookup
    @FindBy (xpath = "//span[normalize-space()='Thank you for your review.']")
    WebElement thankYouForReviewMessage;

    public String getCurrentUrl() {
        waitUntilVisibilityOfElementLocated(By.xpath("//a[normalize-space()='Write Your Review']"), 5);
        log.info("Getting Product Details Page URL : ");
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String getProductName() {
        log.info("Getting product name : " + productName.toString());
        return getTextFromElement(productName);
    }

    public String getProductCategory() {
        log.info("Getting product category : " + productCategory.toString());
        return getTextFromElement(productCategory);
    }

    public String getProductPrice() {
        log.info("Getting product price : " + productPrice.toString());
        return getTextFromElement(productPrice);
    }

    public String getProductAvailability() {
        log.info("Getting product availability : " + productAvailability.toString());
        return getTextFromElement(productAvailability);
    }

    public String getProductCondition() {
        log.info("Getting product condition : " + productCondition.toString());
        return getTextFromElement(productCondition);
    }

    public String getProductBrand() {
        log.info("Getting product brand : " + productBrand.toString());
        return getTextFromElement(productBrand);
    }
    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
        log.info("Clicking on add to cart button : " + addToCartButton.toString());
    }

    public void sendQuantity(String quantity){
        productQuantity.clear();
        sendTextToElement(productQuantity, quantity);
        log.info("Increasing the quantity : " + productQuantity.toString());
    }


    public void sendNameToYourNameField(String name) {
        sendTextToElement(yourNameField, name);
        log.info("Sending " + name + " to your name field : " + yourNameField.toString());
    }

    public void sendEmailToEmailAddressField(String email) {
        sendTextToElement(emailAddressField, email);
        log.info("Sending " + email + " to email field : " + emailAddressField.toString());
    }

    public void sendReviewToAddReviewField(String review) {
        sendTextToElement(addReviewField, review);
        log.info("Sending " + review + " to add review field : " + addReviewField.toString());
    }

    public void clickOnReviewSubmitButton() {
        clickOnElement(reviewSubmitButton);
        log.info("Clicking on the review submit button : " + reviewSubmitButton.toString());
    }

    public String getThankYouForReviewMessage() {
        log.info("Getting thank you for review message test : " + thankYouForReviewMessage.toString());
        return getTextFromElement(thankYouForReviewMessage);
    }


}
