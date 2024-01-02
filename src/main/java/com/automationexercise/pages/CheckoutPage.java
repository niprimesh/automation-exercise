package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends Utility {
    private static final Logger log = LogManager.getLogger(CheckoutPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Review Your Order']")
    WebElement reviewYourOrderText;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Address Details']")
    WebElement addressDetailText;

    @CacheLookup
    @FindBy(xpath = "//textarea[@name='message']")
    WebElement addCommentTextArea;

    @CacheLookup
    @FindBy(xpath = "//li[@class='active']")
    WebElement checkoutText;

    @CacheLookup
    @FindBy (xpath = "//ul[@id = 'address_delivery']/li[4]")
    WebElement deliveryAddress;

    @CacheLookup
    @FindBy (xpath = "//ul[@id = 'address_invoice']/li[4]")
    WebElement billingAddress;

    public String getTextFromCheckOutPage(String text){
        if (text.equalsIgnoreCase("Address Details")){
            log.info("Getting address details text" + addressDetailText.toString());
            return getTextFromElement(addressDetailText);
        } else if (text.equalsIgnoreCase("Review Your Order")) {
            log.info("Getting review your order text" + reviewYourOrderText.toString());
            return getTextFromElement(reviewYourOrderText);
        } else if (text.equalsIgnoreCase("Checkout")) {
            log.info("Getting checkoutext" + checkoutText.toString());
            return getTextFromElement(checkoutText);
        }else {
            return "Text is not correct";
        }
    }

    public void sendCommentToCommentTextArea(String comment) {
        sendTextToElement(addCommentTextArea, comment);
        log.info("Sending comment to comment area" + addCommentTextArea.toString());
    }

    public String getDeliveryAddress(){
        log.info("Getting delivery address : " + deliveryAddress.toString());
        return getTextFromElement(deliveryAddress);
    }

    public String getBillingAddress(){
        log.info("Getting billing address : " + deliveryAddress.toString());
        return getTextFromElement(billingAddress);
    }
}
