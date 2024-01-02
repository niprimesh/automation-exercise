package com.automationexercise.pages;

import com.automationexercise.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class TestCasesPage extends Utility {
    private static final Logger log = LogManager.getLogger(TestCasesPage.class.getName());

//    @CacheLookup
//    @FindBy(xpath = "//b[normalize-space()='Test Cases']")
//    WebElement currentUrL;

    public String getCurrentURL() {
        waitUntilVisibilityOfElementLocated(By.xpath("//b[normalize-space()='Test Cases']"), 5);
        log.info("Getting Home Page URL : ");
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

}