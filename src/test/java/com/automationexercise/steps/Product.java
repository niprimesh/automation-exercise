package com.automationexercise.steps;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailPage;
import com.automationexercise.pages.ProductPage;
import com.automationexercise.pages.ShoppingCartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Product {

    @Then("I should see text {string} on product page")
    public void iShouldSeeTextOnProductPage(String text) {
        Assert.assertEquals(new ProductPage().getAllProductText(), text);
    }

    @And("I click on view product of first product {string}")
    public void iClickOnViewProductOfFirstProduct(String name) {
        new ProductPage().clickOnViewProduct(name);
    }

    @When("I click on header menu option Product {string}")
    public void iClickOnHeaderMenuOptionProduct(String option) {
        new HomePage().clickProductTabMenu(option);
    }


    @And("Verify the product details page and URL")
    public void verifyTheProductDetailsPageAndURL() {
        Assert.assertEquals(new ProductDetailPage().getCurrentUrl(), "https://automationexercise.com/product_details/1");
    }

    @And("Verify product name {string}")
    public void verifyProductName(String name) {
        Assert.assertEquals(new ProductDetailPage().getProductName(), name);
    }

    @And("Verify category {string}")
    public void verifyCategory(String category) {
        Assert.assertEquals(new ProductDetailPage().getProductCategory(), category);
    }

    @And("Verify price {string}")
    public void verifyPrice(String price) {
        Assert.assertEquals(new ProductDetailPage().getProductPrice(), price);
    }

    @And("Verify availability {string}")
    public void verifyAvailability(String avi) {
        Assert.assertEquals(new ProductDetailPage().getProductAvailability(), avi);
    }

    @And("Verify condition {string}")
    public void verifyCondition(String condition) {
        Assert.assertEquals(new ProductDetailPage().getProductCondition(), condition);
    }

    @And("Verify brand {string}")
    public void verifyBrand(String brand) {
        Assert.assertEquals(new ProductDetailPage().getProductBrand(), brand);
    }

    @And("Enter product name {string} in search input")
    public void enterProductNameInSearchInput(String name) {
        new ProductPage().sendDataToSearchField(name);
    }

    @And("I click on search button")
    public void iClickOnSearchButton() {
        new ProductPage().clickOnSearchButton();
    }

    @Then("I should see the text {string} on the page")
    public void iShouldSeeTheTextOnThePage(String text) {
        Assert.assertEquals(new ProductPage().getSearchProductsText(), text);
    }

    @And("I should see the searched product {string}")
    public void iShouldSeeTheSearchedProduct(String expectedPName) {
        Assert.assertEquals(new ProductPage().getSearchedProductName(), expectedPName);
    }

    @And("I hover over first product {string} and click Add to cart")
    public void iHoverOverFirstProductAndClickAddToCart(String name) {
        new ProductPage().mouseHoverAndClickAddToCartOnProduct(name);
    }

    @And("I click Continue Shopping button")
    public void iClickContinueShoppingButton() {
        new ProductPage().clickOnContinueShoppingButton();
    }


    @And("I click View Cart button")
    public void iClickViewCartButton() {
        new ProductPage().clickOnViewCartLinkinPopup();
    }

    @Then("Verify their prices")
    public void verifyTheirPrices() {
    }

    @Then("Verify quantity")
    public void verifyQuantity() {
    }

    @Then("Verify Total Price")
    public void verifyTotalPrice() {
    }

    @And("I add product {string} to the cart")
    public void iAddProductToTheCart(String name) {
        new ProductPage().mouseHoverAndClickAddToCartOnProduct(name);
    }

    @Then("Verify first product {string}")
    public void verifyFirstProduct(String pName) {
        Assert.assertEquals(new ShoppingCartPage().getProductNameFromCart(pName), pName);
    }

    @And("I increase the quantity {string}")
    public void iIncreaseTheQuantity(String quantity) {
        new ProductDetailPage().sendQuantity(quantity);
    }

    @And("I click on add to cart button")
    public void iClickOnAddToCartButton() {
        new ProductDetailPage().clickOnAddToCartButton();
    }

    @And("I click on view cart link in success message")
    public void iClickOnViewCartLinkInSuccessMessage() {
        new ProductPage().clickOnViewCartLinkinPopup();
    }

    @Then("I should see quantity {string}")
    public void iShouldSeeQuantity(String qua) {
        Assert.assertEquals(new ShoppingCartPage().getQuantity(), qua);
    }

    @And("I click on X button corresponding to particular product")
    public void iClickOnXButtonCorrespondingToParticularProduct() {
        new ShoppingCartPage().clickOnRemoveProductButton();
    }

    @Then("Verify that product is removed from the cart {string}")
    public void verifyThatProductIsRemovedFromTheCart(String text) {
        Assert.assertEquals(new ShoppingCartPage().getEmptyCartText(text), text);
    }

    @Then("Verify that categories are visible on left side bar {string}")
    public void verifyThatCategoriesAreVisibleOnLeftSideBar(String text) {
        Assert.assertEquals(new ProductPage().getCategoryText(), text);
    }

    @Then("I click on {string} category")
    public void iClickOnCategory(String category) {
        new ProductPage().clickOnCategory(category);
    }

    @And("I click on {string} in women category")
    public void iClickOnInWomenCategory(String sCategory) {
        new ProductPage().clickOnWomenSubCategory(sCategory);
    }

    @And("I should see {string} page title")
    public void iShouldSeePageTitle(String title) {
        Assert.assertEquals(new ProductPage().getSubMenuPageTitleForWomenDress(), title);
    }

    @And("I click on {string} in men category")
    public void iClickOnInMenCategory(String mCategory) {
        new ProductPage().clickOnMenSubCategory(mCategory);
    }


    @And("I click on brand {string}")
    public void iClickOnBrand(String brand) {
        new ProductPage().clickOnBrand(brand);
    }

    @Then("I verify the product {string} in shopping cart")
    public void iVerifyTheProductInShoppingCart(String text) {
        Assert.assertEquals(new ShoppingCartPage().getProductNameFromCart(text), text);
    }

    @And("I enter name {string}")
    public void iEnterName(String name) {
        new ProductDetailPage().sendNameToYourNameField(name);
    }

    @And("I enter email {string}")
    public void iEnterEmail(String email) {
        new ProductDetailPage().sendEmailToEmailAddressField(email);
    }

    @And("I enter the review {string}")
    public void iEnterTheReview(String review) {
        new ProductDetailPage().sendReviewToAddReviewField(review);
    }

    @Then("Verify the success message for review {string}")
    public void verifyTheSuccessMessageForReview(String text) {
        Assert.assertEquals(new ProductDetailPage().getThankYouForReviewMessage(), text);
    }

    @And("I click On submit review button")
    public void iClickOnSubmitReviewButton() {
        new ProductDetailPage().clickOnReviewSubmitButton();
    }

    @When("I scroll down up to recommended items text")
    public void iScrollDownUpToRecommendedItemsText() {
        new HomePage().scrollDownToRecommendedItems();
    }

    @Then("I should see {string} text")
    public void iShouldSeeText(String text) {
        Assert.assertEquals(new HomePage().getRecommendedItemText(), text);
    }

    @And("I add to cart {string} product from recommended items")
    public void iAddToCartProductFromRecommendedItems(String pName) {
        new HomePage().clickAddToCartOnRecommendedItems(pName);
    }

    @Then("Verify product {string}")
    public void verifyProduct(String Name) {
        Assert.assertEquals(new ShoppingCartPage().getProductNameFromCart(Name), Name);
    }

    @And("I should see {string} page title for men")
    public void iShouldSeePageTitleForMen(String title) {
        Assert.assertEquals(new ProductPage().getSubMenuPageTitleForMenTshirt(), title);
    }
}
