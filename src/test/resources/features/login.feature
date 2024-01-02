@regression
Feature: As a user,
  I should login successfully with correct email and password
  I should not login successfully with incorrect email and password
  I should logout successfully
  I should Place Order: Login before Checkout
  I should Place Order: Login before Checkout

  Background:
    Given I am on homepage and verify the homepage URL
    When I click on header menu option Signup "Signup / Login"

  @smoke @sanity
    #Test Case 2: Login User with correct email and password
  Scenario: User should login successfully with correct email and password
    Then I should see the login page text "Login to your account"
    And I enter "ogpatel90@gmail.com" email and "ogpatel@90" password for login
    And I click on button "Login"
    Then I should see the text "Logged in as " "Priya"
#    And I click on header menu option Deleted Account "Delete Account"
#    Then I should see the account deleted message "ACCOUNT DELETED!"

  @sanity
    #Test Case 3: Login User with incorrect email and password
  Scenario: User should login successfully with correct email and password
    Then I should see the login page text "Login to your account"
    And I enter "patel@gmail.com" email and "Niles@123" password for login
    And I click on button "Login"
    Then Verify error "Your email or password is incorrect!" is visible

  @smoke @sanity
#  Test Case 4: Logout User
  Scenario: I should logout successfully
    Then I should see the login page text "Login to your account"
    And I enter "ogpatel90@gmail.com" email and "ogpatel@90" password for login
    And I click on button "Login"
    Then I should see the text "Logged in as " "Priya"
    And I click on header menu option logout "Logout"
    Then Verify that user is navigated to login page

  @sanity
    # Test Case 16: Place Order: Login before Checkout
  Scenario: User should place the order : Login before checkout
    And I enter "ogpatel90@gmail.com" email and "ogpatel@90" password for login
    And I click on button "Login"
    Then I should see the text "Logged in as " "Priya"
    And I add product "Blue Top" to the cart
    And I click on header menu option Cart "Cart"
    And I should see the welcome text on shopping cart page "Shopping Cart"
    And I click on Proceed to Checkout button
    And I should see the text on checkout page "Review Your Order"
    And I should see the text on checkout page "Address Details"
    And I enter details into comment area "Please deliver it on time."
    And I click on place order button
    And I enter payment details "Original Patel" "429333322220000" "311" "08" and "2025"
    And I click on Pay and Confirm Order button
    Then I should see the order confirmation message "Congratulations! Your order has been confirmed!"
#    And I click on header menu option Deleted Account "Delete Account"
#    Then I should see the account deleted message "ACCOUNT DELETED!"
#    Then I click on continue button after deleting account