package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends Utility {
    private static final Logger log = LogManager.getLogger(CheckoutPage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//input[@name='name_on_card']")
    WebElement nameOnCard;

    @CacheLookup
    @FindBy(xpath = "//input[@name='card_number']")
    WebElement cardNumber;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='ex. 311']")
    WebElement cvv;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='MM']")
    WebElement expMonth;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='YYYY']")
    WebElement expYear;

    @CacheLookup
    @FindBy(xpath = "//button[@id='submit']")
    WebElement payAndConfirm;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Place Order')]")
    WebElement placeOrderButton;

    @CacheLookup
    @FindBy(xpath = "//p[normalize-space()='Congratulations! Your order has been confirmed!']")
    WebElement orderSuccessText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueAfterOrderPlaced;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Download Invoice']")
    WebElement downloadInvoiceButton;


    public void addCardDetails(String name, String cNumber, String cvv, String month, String year) {
        sendTextToElement(nameOnCard, name);
        log.info("Sending the name " + nameOnCard.toString());
        sendTextToElement(cardNumber, cNumber);
        log.info("Sending the card number " + cardNumber.toString());
        sendTextToElement(this.cvv, cvv);
        log.info("Sending the cvv number " + this.cvv.toString());
        sendTextToElement(expMonth, month);
        log.info("Sending the month number " + expMonth.toString());
        sendTextToElement(expYear, year);
        log.info("Sending the year number " + expYear.toString());
    }

    public void clickOnPlaceOrderButton() {
        clickOnElement(placeOrderButton);
        log.info("Clicking on place order button button " + placeOrderButton.toString());
    }

    public void clickOnPayAndConfirmButton() {
        clickOnElement(payAndConfirm);
        log.info("Clicking on place order button button " + payAndConfirm.toString());
    }

    public String getOrderSuccessMessage() {
        log.info("Getting order success message " + orderSuccessText);
        return getTextFromElement(orderSuccessText);
    }

    public void clickOnDownloadInvoiceButton() {
        clickOnElement(downloadInvoiceButton);
        log.info("Clicking on place order button button " + downloadInvoiceButton.toString());
    }

    public void clickOnContinueSAfterOrderPlaced() {
        clickOnElement(continueAfterOrderPlaced);
        log.info("Clicking on place order button button " + continueAfterOrderPlaced.toString());
    }
}
