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

public class ProductPage extends Utility {
    private static final Logger log = LogManager.getLogger(ProductPage.class.getName());
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='All Products']")
    WebElement allProductText;

    @CacheLookup
    @FindBy (xpath = "//div[@class = 'productinfo text-center']/p")
    List<WebElement> productName;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'productinfo text-center']/p")
    List<WebElement> productList;

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'nav nav-pills nav-justified']/li/a")
    WebElement viewProductTab;

    @CacheLookup
    @FindBy(id = "search_product")
    WebElement searchProductField;

    @CacheLookup
    @FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement searchButton;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Searched Products']")
    WebElement searchProductsText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='productinfo text-center']//p")
    WebElement searchProductsName;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    WebElement continueShoppingButton;

    @CacheLookup
    @FindBy(xpath = "//u[normalize-space()='View Cart']")
    WebElement viewCartLink;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Category']")
    WebElement categoryText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Women']")
    WebElement womenCategory;

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'Women']/div/ul/li/a")
    List<WebElement> womenSubMenuList;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Men']")
    WebElement menCategory;

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'Men']/div/ul/li/a")
    List<WebElement> menSubMenuList;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Kids']")
    WebElement kidsCategory;

    @CacheLookup
    @FindBy(xpath = "//h2[@class = 'title text-center']")
    WebElement subMenuPageTitle;

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'nav nav-pills nav-stacked']/li/a")
    List<WebElement> brandsList;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Women - Dress Products']")
    WebElement dressSubMenuWomenTitlePage;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Men - Tshirts Products']")
    WebElement tshirtSubMenuMenTitlePage;

    public String getAllProductText() {
        log.info("Getting all product text" + allProductText.toString());
        return getTextFromElement(allProductText);
    }

    public void mouseHoverAndClickAddToCartOnProduct(String pName) {
        for (WebElement pr : productList) {
            if (pr.getText().equalsIgnoreCase(pName)) {
                mouseHoverToElement(pr);
                log.info("Hovering mouse over " + pName + " : " + productList.toString());
                try {
                    addToCartButton.click();
                } catch (Exception e) {
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@class='btn btn-default add-to-cart']")));
                }
                log.info("Click on " + pName + " Add to Cart button : " + productList.toString());
                break;
            }
        }
    }

    public void sendDataToSearchField(String name) {
        sendTextToElement(searchProductField, name);
        log.info("Sending the data to search product field " + searchProductField.toString());
    }

    public void clickOnSearchButton() {
        clickOnElement(searchButton);
        log.info("Clicking on search button" + searchButton.toString());
    }

    public String getSearchProductsText() {
        log.info("Verifying the searched Products text" + searchProductsText.toString());
        return getTextFromElement(searchProductsText);
    }

    public String getSearchedProductName() {
        log.info("Getting Searched Product name: " + searchProductsName.toString());
        return getTextFromElement(searchProductsName);
    }

    public void clickOnViewCartLinkinPopup() {
        clickOnElement(viewCartLink);
        log.info("Clicking on the view cart link: " + viewCartLink.toString());
    }

    public void clickOnViewProduct(String pName) {
        for (WebElement p : productName) {
            if(p.getText().equalsIgnoreCase(pName)) {
                //driver.findElement(with(By.xpath("//ul[@class = 'nav nav-pills nav-justified']/li/a")).below(p)).click();
                driver.findElement(By.xpath("//ul[@class = 'nav nav-pills nav-justified']/li/a")).click();
                log.info("Clicking on view product tab of " + pName);
                break;
            }
        }
    }

    public void clickOnContinueShoppingButton() {
        clickOnElement(continueShoppingButton);
        log.info("Clicking on continuer shopping button : " + continueShoppingButton.toString());
    }

    public String getCategoryText() {
        log.info("Getting Category text: " + categoryText.toString());
        return getTextFromElement(categoryText);
    }

    public void clickOnCategory(String category) {
        if (category.equalsIgnoreCase("Women")) {
            clickOnElement(womenCategory);
            log.info("Clicking on women category : " + womenCategory.toString());
        } else if (category.equalsIgnoreCase("Men")) {
            clickOnElement(menCategory);
            log.info("Clicking on men category : " + menCategory.toString());
        } else if (category.equalsIgnoreCase("Child")) {
            clickOnElement(kidsCategory);
            log.info("Clicking on kids category : " + kidsCategory.toString());
        } else {
            System.out.println("Category is not available");
        }
    }

    public void clickOnWomenSubCategory(String womenSubCategory) {
        for (WebElement sub : womenSubMenuList) {
            if (sub.getText().equalsIgnoreCase(womenSubCategory)) {
                clickOnElement(sub);
                log.info("Clicking on " + womenSubCategory + " of women sub category : " + womenSubMenuList.toString());
                break;
            } else {
                System.out.println("Sub category is not available");
            }
        }
    }

    public void clickOnMenSubCategory(String womenSubCategory) {
        for (WebElement sub : menSubMenuList) {
            if (sub.getText().equalsIgnoreCase(womenSubCategory)) {
                clickOnElement(sub);
                log.info("Clicking on " + menSubMenuList + " of women sub category : " + menSubMenuList.toString());
                break;
            } else {
                System.out.println("Sub category is not available");
            }
        }
    }

    public String getSubMenuPageTitle() {
        waitUntilVisibilityOfElementLocated((By) driver.findElement(By.xpath("//h2[@class = 'title text-center']")), 5);
        log.info("Getting Sub Menu Page Title : " + subMenuPageTitle.toString());
        return getTextFromElement(subMenuPageTitle);
    }

    public String getSubMenuPageTitleForWomenDress() {
        log.info("Getting Sub Menu Page Title : " + dressSubMenuWomenTitlePage.toString());
        return getTextFromElement(dressSubMenuWomenTitlePage);
    }

    public String getSubMenuPageTitleForMenTshirt() {
        log.info("Getting Sub Menu Page Title : " + tshirtSubMenuMenTitlePage.toString());
        return getTextFromElement(tshirtSubMenuMenTitlePage);
    }

    public void clickOnBrand(String brand){
        for (WebElement b : brandsList) {
            System.out.println(b);
            if (b.getText().equalsIgnoreCase(brand)){
                b.click();
                log.info("Clicking on " + brand + " in Brands tab : " + brandsList.toString());
                break;
            } else {
                System.out.println("Brand name is not available");
            }
        }
    }

}

