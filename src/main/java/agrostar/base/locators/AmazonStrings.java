package agrostar.base.locators;

import org.openqa.selenium.By;

public class AmazonStrings {

	// Login page locators

	public static By signInLink = By.id("nav-link-accountList");
	public static By userEmail = By.id("ap_email");
	public static By loginTitle = By.cssSelector("div.a-section>form>div>div>div>h1");
	public static By continueButton = By.id("continue");
	public static By userPassword = By.id("ap_password");
	public static By loginButton = By.id("signInSubmit");
	public static By sendOtpButton = By.cssSelector("span>input#continue");
	public static By optTextBox = By.cssSelector("input[name='code']");

	// Place product locators

	public static By verifyUserName = By.cssSelector("#nav-link-accountList > span.nav-line-1");
	public static By productSearchBox = By.id("twotabsearchtextbox");
	public static By searchIcon = By.cssSelector("#nav-search > form > div.nav-right > div > input");
	public static By productTitle = By.id("productTitle");

	public static By getProductByNameAndSpec(String name, String specification, String color) {
		return By.xpath("//span[text()='" + name + " (" + specification + ") - " + color + "']");
	}

	public static By addToCartButton = By.id("add-to-cart-button");
	public static By getCartCoutn = By.id("nav-cart-count");
	public static By cartLink = By.id("nav-cart");
	public static By quantityDropdown = By.cssSelector("span>select[name='quantity']");
	public static By proceedToByButton = By
			.cssSelector("#sc-buy-box-ptc-button > span > input[name='proceedToCheckout']");

	// Address locators

	public static By name = By.id("enterAddressFullName");
	public static By mobile = By.id("enterAddressPhoneNumber");
	public static By pincode = By.id("enterAddressPostalCode");
	public static By companyName = By.id("enterAddressAddressLine1");
	public static By city = By.id("enterAddressCity");
	public static By submitAddress = By.cssSelector("div#newShippingAddressFormFromIdentity>div>div:nth-child(1)>form>div.a-form-actions > span > span.a-button-inner > input");

	public static By deliveryOptionPageTitle = By.cssSelector("#shippingOptionFormId >div *>h1");
	public static By signoutLink = By.id("nav-item-signout");

}
