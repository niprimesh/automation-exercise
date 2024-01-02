@regression
Feature: As a user,
  I should log the contact us form
  I should redirect to Test Cases page successfully
  I should subscribe in the homepage
  I should subscribe in the Cart page
  I should remove the product from cart
  I should download invoice after purchase order
  I should scroll down and scroll up using Arrow button at bottom right corner
  I should scroll down and scroll up without Arrow button

  Background:
    Given I am on homepage and verify the homepage URL

  @sanity
#Test Case 6: Contact Us Form
  Scenario: User should log the contact us form
    When I click on header menu option Contact us "Contact us"
    Then I should see welcome text on contact us page "GET IN TOUCH"
    And I enter "Nimesh" name to name field
    And I enter "ogpatel90@gmail.com" email to email field
    And I enter "About product" subject to subject field
    And I enter "This product is nice" message to message field
    And I upload file
    And I click on submit button
    And I click on ok button popup
    Then I should see the success message "Success! Your details have been submitted successfully."
    And I click on header menu option Home "Home"
    Then I am on homepage and verify the homepage URL

  @sanity
#  Test Case 7: Verify Test Cases Page
  Scenario: User should verify test cases page
    When I click on header menu option Test cases "Test Cases"
    Then I am on text cases page and verify the test-cases URL "https://automationexercise.com/test_cases"

  @sanity
#  Test Case 10: Verify Subscription in home page
  Scenario: User should verify the subscription in home page
    When I scroll down to subscription
    Then Verify the text "SUBSCRIPTION"
    And I enter email address in input "ogpatel90@gmail.com"
    And I click on arrow button
    Then Verify the success message "You have been successfully subscribed!"

  @sanity
#  Test Case 11: Verify Subscription in Cart page
  Scenario: User should verify the subscription in cart page
    And I click on header menu option Cart "Cart"
    When I scroll down to subscription
    Then Verify the text "SUBSCRIPTION"
    And I enter email address in input "ogpatel90@gmail.com"
    And I click on arrow button
    Then Verify the success message "You have been successfully subscribed!"

  @sanity
#  Test Case 24: Download Invoice after purchase order
  Scenario: User should Download Invoice after purchase order
    When I add product "Blue Top" to the cart
    And I click View Cart button
    And I should see the welcome text on shopping cart page "Shopping Cart"
    And I click on Proceed to Checkout button
    And I click on register link in the checkout popup
    And I send name "Nimesh" and email "patel" to signup
    And I click on button "Signup"
    And I fill all details in signup page "Mr" "Nimesh@123" "01" "March" "1999" "Nimesh" "Patel" "Vrajbhumi" "vraj" "India" "Gujarat" "Baroda" "385006" "9879796777"
    And I click on news letter subscription check box
    And I click on special offers check box
    And I click on Create Account button
    Then I see account created message "ACCOUNT CREATED!"
    And I click on continue button
    Then I should see the text "Logged in as " "Nimesh"
    And I click on header menu option Cart "Cart"
    And I click on Proceed to Checkout button
    And I should see the text on checkout page "Review Your Order"
    And I should see the text on checkout page "Address Details"
    And I enter details into comment area "Please deliver it on time."
    And I click on place order button
    And I enter payment details "Original Patel" "429333322220000" "311" "08" and "2025"
    And I click on Pay and Confirm Order button
    Then I should see the order confirmation message "Congratulations! Your order has been confirmed!"
    And I Click Download Invoice button
    And Click Continue button
    And I click on header menu option Deleted Account "Delete Account"
    Then I should see the account deleted message "ACCOUNT DELETED!"
    Then I click on continue button after deleting account

  @sanity
# Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality
  Scenario: User should scroll down and scroll up using Arrow button at bottom right corner
    When I scroll down to subscription
    Then Verify the text "SUBSCRIPTION"
    And I Click on arrow at bottom right side to move upward
    Then Verify that page is scrolled up and "Full-Fledged practice website for Automation Engineers" text is visible on screen

  @sanity
# Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality
  Scenario: User should Scroll Up without 'Arrow' button and Scroll Down functionality
    When I scroll down to subscription
    Then Verify the text "SUBSCRIPTION"
    And Scroll up page to top
    Then Verify that page is scrolled up and "Full-Fledged practice website for Automation Engineers" text is visible on screen



