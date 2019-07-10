@orderProduct
Feature: Order Product

  # please add user name and password into the config file
  Scenario: Automate and test the process of placing a particular product into a cart
    Given user launch base url
    Then verify page is loaded
    And user click on Sign in link
    Then verify title "Login" is displayed
    And user enter an email as a user name
    And click on Continue button
    And enter password
    When user click on Login button
    # please enter OTP manually first time with in 15 seconds
    Then verify user is logged in
    When user enter product name "Apple iPhone X" in search textbox and click on search icon
    Then verify page is completly loaded
    # Apple iPhone X- 256GB in Space gray color product is unavailable thats why here used 64GB.
    When user click on product "Apple iPhone X" which has specifications as "64GB" memory and "Silver"
    Then verify product "Apple iPhone X (64GB) - Silver" title is displayed
    And verify Add to Cart button is displayed
    When user click on Add to Cart button
    Then verify product is added into the cart
    And user open the Cart window in new tab
    And set the Quantity is "2"
    When user click on Proceed to Buy button
    #And enter password and click on login button
    Then verify user is on address page
    And user enter Full name "Test"
    And enter Mobile number "1234567890"
    And enter Pincode "411014"
    And enter Company name "Agrostar"
    And enter City name "Pune"
    When user click on Continue button
    Then verify user is on Delivery Option page
    And user close the cart window
    When user hover the mouse on Account & Lists tab and click on the Sign Out link
    Then verify user is logout
    And user close all opened window
