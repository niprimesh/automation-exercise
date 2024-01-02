@regression
Feature: As a user,
  I should verify all products and product detail page
  I should search product
  I should add products in cart
  I should verify product quantity in cart
  I should view category products
  I should view and cart brand products
  I should search product and verify cart after login
  I should add review on product
  I should add to cart from recommended items

  Background:
    Given I am on homepage and verify the homepage URL

  @smoke @sanity
#  Test Case 8: Verify All Products and product detail page
  Scenario: User should verify all products and product detail page
    When I click on header menu option Product "Products"
    Then I should see text "ALL PRODUCTS" on product page
    And I click on view product of first product "Blue Top"
    And Verify the product details page and URL
    And Verify product name "Blue Top"
    And Verify category "Category: Women > Tops"
    And Verify price "Rs. 500"
    And Verify availability "Availability: In Stock"
    And Verify condition "Condition: New"
    And Verify brand "Brand: Polo"

  @smoke @sanity
#  Test Case 9: Search Product
  Scenario: User should search the product
    When I click on header menu option Product "Products"
    Then I should see text "ALL PRODUCTS" on product page
    And Enter product name "Blue Top" in search input
    And I click on search button
    Then I should see the text "SEARCHED PRODUCTS" on the page
    And I should see the searched product "Blue Top"

  @smoke @sanity
#  Test Case 12: Add Products in Cart
  Scenario: User should add the product into cart
    When I click on header menu option Product "Products"
    And I add product "Blue Top" to the cart
    And I click Continue Shopping button
    Then I add product "Men Tshirt" to the cart
    And I click View Cart button
    Then Verify product "Blue Top"
#    Then Verify product "Men Tshirt"


@sanity
#  Test Case 13: Verify Product quantity in Cart
  Scenario: User should verify product quantity in cart
    When I click on view product of first product "Blue Top"
    And Verify the product details page and URL
    And Verify product name "Blue Top"
    And Verify category "Category: Women > Tops"
    And Verify price "Rs. 500"
    And Verify availability "Availability: In Stock"
    And Verify condition "Condition: New"
    And Verify brand "Brand: Polo"
    And I increase the quantity "4"
    And I click on add to cart button
    And I click on view cart link in success message
    Then I should see quantity "4"

  @sanity
#  Test Case 17: Remove Products From Cart
  Scenario: User should remove product from cart
    When I add product "Blue Top" to the cart
    And I click View Cart button
    And I should see the welcome text on shopping cart page "Shopping Cart"
    And I click on X button corresponding to particular product
    Then Verify that product is removed from the cart "Cart is empty!"

@sanity
#    Test Case 18: View Category Products
  Scenario: User should view category products
    When Verify that categories are visible on left side bar "CATEGORY"
    Then I click on "Women" category
    And I click on "Dress" in women category
    And I should see "WOMEN - DRESS PRODUCTS" page title
    Then I click on "Men" category
    And I click on "Tshirts" in men category
    And I should see "MEN - TSHIRTS PRODUCTS" page title for men

@sanity
# Test Case 19: View & Cart Brand Products
  Scenario: User should view Brand Products
    Given I am on homepage and verify the homepage URL
    When I click on header menu option Product "Products"
    And I click on brand "POLO"
    Then I should see "BRAND - POLO PRODUCTS" page title
    And I click on brand "H&M"
    Then I should see "BRAND - H&M PRODUCTS" page title

@sanity
# Test Case 20: Search Products and Verify Cart After Login
  Scenario: User should search product and verify cart after login
    When I click on header menu option Product "Products"
    Then I should see text "ALL PRODUCTS" on product page
    And Enter product name "Blue Top" in search input
    And I click on search button
    Then I should see the text "SEARCHED PRODUCTS" on the page
    And I should see the searched product "Blue Top"
    And I add product "Blue Top" to the cart
    And I click on view cart link in success message
    Then I verify the product "Blue Top" in shopping cart
    When I click on header menu option signup "Signup / Login"
    Then I should see the login page text "Login to your account"
    And I enter "ogpatel90@gmail.com" email and "ogpatel@90" password for login
    And I click on button "Login"
    And I click on header menu option Cart "Cart"
    Then I verify the product "Blue Top" in shopping cart

@sanity
#  Test Case 21: Add review on product
  Scenario: User should add review on product
    When I click on header menu option Product "Products"
    Then I should see text "ALL PRODUCTS" on product page
    And I click on view product of first product "Blue Top"
    And I enter name "Nimesh"
    And I enter email "ogpatel90@gmail.com"
    And I enter the review "Good product"
    And I click On submit review button
    Then Verify the success message for review "Thank you for your review."

@sanity
#    Test Case 22: Add to cart from Recommended items
  Scenario: User should add to cart the products from Recommended items
    When I scroll down up to recommended items text
    Then I should see "RECOMMENDED ITEMS" text
    And I add to cart "Winter Top" product from recommended items
    And I click on view cart link in success message
    Then I verify the product "Winter Top" in shopping cart
