package agrostar.base.helper;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;

import agrostar.base.common.Common;
import agrostar.base.locators.AmazonStrings;

/**
 * Its contains all utility methods
 * 
 * @author Omkar
 * 
 */
public class AmazonHelper extends Common {

	public static String parentHandle = "";

	/**
	 * get cart count
	 * 
	 * @return
	 */
	public int getCartCount() {
		String count = getText(AmazonStrings.getCartCoutn);
		return Integer.parseInt(count);
	}

	/**
	 * open cart window in new tab
	 */
	public void openCartWindowNewTab() {
		parentHandle = getWindowHandle();
		((JavascriptExecutor) getDriver()).executeScript("window.open('" + System.getProperty("baseUrl")
				+ "','_blank');");
		Set<String> allHandles = getWindowHandles();

		for (String handle : allHandles) {
			if (!handle.equals(parentHandle))
				switchToWindow(handle);
		}

		waitElementDisplayedImplicitlyForSeconds(AmazonStrings.cartLink, 10);
		click(AmazonStrings.cartLink);
	}

	/**
	 * click on send otp button if present
	 */
	public void clickOnSendOTPButton() {
		if (isElementPresent(AmazonStrings.sendOtpButton)) {
			click(AmazonStrings.sendOtpButton);
			waitElementDisplayedImplicitlyForSeconds(AmazonStrings.optTextBox, 10);
		}
	}
}
