package agrostar.test.testSteps;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import agrostar.base.helper.AmazonHelper;
import agrostar.base.locators.AmazonStrings;
import agrostar.test.testRunner.TestBase;

public class AmazonSteps extends TestBase {

	@Given("^user launch base url$")
	public void user_launch_base_url() throws Throwable {
		log.info("user launch base url");
		app.getCommon().openUrl(System.getProperty("baseUrl"));
		app.getCommon().maximizeWindow();
	}

	@Then("^verify page is loaded$")
	public void verify_page_is_loaded() throws Throwable {
		log.info("verify page is loaded");
		app.getCommon().waitForPageLoad();
	}

	@Then("^user click on Sign in link$")
	public void user_click_on_Sign_in_link() throws Throwable {
		log.info("user click on Sign in link");
		app.getCommon().click(AmazonStrings.signInLink);
	}

	@Then("^verify title \"([^\"]*)\" is displayed$")
	public void verify_title_is_displayed(String title) throws Throwable {
		log.info("verify title "+title+" is displayed");
		app.getCommon().waitElementTextToBePresentImplicitlyForSeconds(AmazonStrings.loginTitle, title, 10);
	}

	@Then("^user enter an email as a user name$")
	public void user_enter_an_email_as_a_user_name() throws Throwable {
		log.info("user enter an email as a user name");
		app.getCommon().type(AmazonStrings.userEmail, System.getProperty("userEmail"));
	}

	@Then("^click on Continue button$")
	public void click_on_Continue_button() throws Throwable {
		log.info("click on Continue button");
		app.getCommon().click(AmazonStrings.continueButton);
	}

	@Then("^enter password$")
	public void enter_password() throws Throwable {
		log.info("enter password");
		app.getCommon().type(AmazonStrings.userPassword, System.getProperty("password"));
	}

	@When("^user click on Login button$")
	public void user_click_on_Login_button() throws Throwable {
		log.info("user click on Login button");
		app.getCommon().click(AmazonStrings.loginButton);
		app.getAmazonHelper().clickOnSendOTPButton();
	}

	@Then("^verify user is logged in$")
	public void verify_user_is_logged_in() throws Throwable {
		log.info("verify user is logged in");
		app.getCommon().waitElementDisplayedImplicitlyForSeconds(AmazonStrings.verifyUserName, 20);
	}

	@When("^user enter product name \"([^\"]*)\" in search textbox and click on search icon$")
	public void user_enter_product_name_in_search_textbox_and_click_on_search_icon(String productName) throws Throwable {
		log.info("user enter product name "+productName+" in search textbox and click on search icon");
		app.getCommon().type(AmazonStrings.productSearchBox, productName);
		app.getCommon().click(AmazonStrings.searchIcon);
	}

	@Then("^verify page is completly loaded$")
	public void verify_page_is_completly_loaded() throws Throwable {
		log.info("verify page is completly loaded");
		app.getCommon().waitForPageLoad();
	}

	@When("^user click on product \"([^\"]*)\" which has specifications as \"([^\"]*)\" memory and \"([^\"]*)\"$")
	public void user_click_on_product_which_has_specifications_as_memory_and(String productName, String memory, String colour) throws Throwable {
		log.info("user click on product "+productName+" which has specifications as "+memory+" memory and "+colour);
		app.getCommon().click(AmazonStrings.getProductByNameAndSpec(productName, memory, colour));
	}

	@Then("^verify product \"([^\"]*)\" title is displayed$")
	public void verify_product_title_is_displayed(String productTitle) throws Throwable {
		log.info("verify product "+productTitle+" title is displayed");
		app.getCommon().waitElementTextToBePresentImplicitlyForSeconds(AmazonStrings.productTitle, productTitle, 10);
	}

	@Then("^verify Add to Cart button is displayed$")
	public void verify_Add_to_Cart_button_is_displayed() throws Throwable {
		log.info("verify Add to Cart button is displayed");
		app.getCommon().waitElementDisplayedImplicitlyForSeconds(AmazonStrings.addToCartButton, 10);
	}

	@When("^user click on Add to Cart button$")
	public void user_click_on_Add_to_Cart_button() throws Throwable {
		log.info("user click on Add to Cart button");
		app.getCommon().click(AmazonStrings.addToCartButton);
	}

	@Then("^verify product is added into the cart$")
	public void verify_product_is_added_into_the_cart() throws Throwable {
		log.info("verify product is added into the cart");
		Assert.assertEquals(true, app.getAmazonHelper().getCartCount() > 0);
	}

	@Then("^user open the Cart window in new tab$")
	public void user_open_the_Cart_window_in_new_tab() throws Throwable {
		log.info("user open the Cart window in new tab");
		//app.getCommon().click(AmazonStrings.cartLink);
		app.getAmazonHelper().openCartWindowNewTab();
	}

	@Then("^set the Quantity is \"([^\"]*)\"$")
	public void set_the_Quantity_is(String quantity) throws Throwable {
		log.info("set the Quantity is "+quantity);
		app.getCommon().selectDropdownelement(AmazonStrings.quantityDropdown, quantity);
	}

	@When("^user click on Proceed to Buy button$")
	public void user_click_on_Proceed_to_Buy_button() throws Throwable {
		log.info("user click on Proceed to Buy button");
		app.getCommon().click(AmazonStrings.proceedToByButton);
	}

	@When("^enter password and click on login button$")
	public void enter_password_and_click_on_login_button() throws Throwable {
		log.info("enter password and click on login button");
		app.getCommon().type(AmazonStrings.userPassword, System.getProperty("password"));
		app.getCommon().click(AmazonStrings.loginButton);
	}

	@Then("^verify user is on address page$")
	public void verify_user_is_on_address_page() throws Throwable {
		log.info("verify user is on address page");
		app.getCommon().waitElementDisplayedImplicitlyForSeconds(AmazonStrings.name, 10);
	}

	@Then("^user enter Full name \"([^\"]*)\"$")
	public void user_enter_Full_name(String name) throws Throwable {
		log.info("user enter Full name "+name);
		app.getCommon().type(AmazonStrings.name, name);
	}

	@Then("^enter Mobile number \"([^\"]*)\"$")
	public void enter_Mobile_number(String mobile) throws Throwable {
		log.info("enter Mobile number "+mobile);
		app.getCommon().type(AmazonStrings.mobile, mobile);
	}

	@Then("^enter Pincode \"([^\"]*)\"$")
	public void enter_Pincode(String pincode) throws Throwable {
		log.info("enter Pincode "+pincode);
		app.getCommon().type(AmazonStrings.pincode, pincode);
	}

	@Then("^enter Company name \"([^\"]*)\"$")
	public void enter_Company_name(String companyName) throws Throwable {
		log.info("enter Company name "+companyName);
		app.getCommon().type(AmazonStrings.companyName, companyName);
	}
	
	@Then("^enter City name \"([^\"]*)\"$")
	public void enter_City_name(String cityName) throws Throwable {
		log.info("enter City name "+cityName);
		app.getCommon().type(AmazonStrings.city, cityName);
	}

	@When("^user click on Continue button$")
	public void user_click_on_Continue_button() throws Throwable {
		log.info("user click on Continue button");
		app.getCommon().click(AmazonStrings.submitAddress);
	}

	@Then("^verify user is on Delivery Option page$")
	public void verify_user_is_on_Delivery_Option_page() throws Throwable {
		log.info("verify user is on Delivery Option page");
		app.getCommon().waitElementDisplayedImplicitlyForSeconds(AmazonStrings.deliveryOptionPageTitle, 10);
	}

	@Then("^user close the cart window$")
	public void user_close_the_cart_window() throws Throwable {
	    log.info("user close the cart window");
	    app.getCommon().close();
	    app.getCommon().switchToWindow(AmazonHelper.parentHandle);
	}

	@When("^user hover the mouse on Account & Lists tab and click on the Sign Out link$")
	public void user_hover_the_mouse_on_Account_Lists_tab_and_click_on_the_Sign_Out_link() throws Throwable {
		log.info("user hover the mouse on Account & Lists tab and click on the Sign Out link");
		app.getCommon().hoverToElement(AmazonStrings.signInLink);
		app.getCommon().click(AmazonStrings.signoutLink);
	}

	@Then("^verify user is logout$")
	public void verify_user_is_logout() throws Throwable {
		log.info("verify user is logout");
		app.getCommon().waitElementDisapperedImplicitly(AmazonStrings.verifyUserName, 10);
		app.getCommon().waitElementDisplayedImplicitlyForSeconds(AmazonStrings.continueButton, 10);
	}
	
	@Then("^user close all opened window$")
	public void user_close_all_opened_window() throws Throwable {
		log.info("user close all open window");
		app.getWebdriverHelper().stop();
	}
}
