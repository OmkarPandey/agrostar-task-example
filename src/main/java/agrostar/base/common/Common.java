package agrostar.base.common;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

/**
 * Common utility class, its contains common method
 * 
 * @author Omkar
 * 
 */
public class Common {

	private WebDriver driver;

	public Common() {
		driver = WebdriverHelper.getWebdriverHelper().getDriver();
	}

	/**
	 * return driver instance
	 * 
	 * @return
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * close current window
	 */
	public void close() {
		driver.close();
	}

	/**
	 * open page url
	 * 
	 * @param url
	 */
	public void openUrl(String url) {
		driver.get(url);
	}

	/**
	 * common method for finding elements base don locator
	 * 
	 * @param locator
	 * @return
	 */
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	/**
	 * type text based on locators
	 * 
	 * @param locator
	 * @param text
	 */
	public void type(By locator, String text) {
		findElement(locator).clear();
		findElement(locator).sendKeys(text);
	}

	/**
	 * click on button
	 * 
	 * @param locator
	 */
	public void click(By locator) {
		findElement(locator).click();
	}

	/**
	 * set page level wait
	 * 
	 * @param time
	 */
	public void setImplicitWait(int second) {
		driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
	}

	/**
	 * Wait page completely load in 60 seconds
	 */
	public void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Predicate<WebDriver> pageLoaded = new Predicate<WebDriver>() {
			public boolean apply(WebDriver input) {
				return ((JavascriptExecutor) input).executeScript("return document.readyState").equals("complete");
			}
		};
		wait.until(pageLoaded);
	}

	/**
	 * maximize current window
	 */
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * Refresh page
	 * 
	 * @throws InterruptedException
	 */
	public void refresh() throws InterruptedException {
		driver.navigate().refresh();
	}

	/**
	 * return current window handle
	 * 
	 * @return
	 */
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	/**
	 * get all opened window handles
	 * 
	 * @return
	 */
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	/**
	 * switch to new window tab based on window handle
	 * 
	 * @param handle
	 */
	public void switchToWindow(String handle) {
		driver.switchTo().window(handle);
	}

	/**
	 * close current window
	 * 
	 * @param handle
	 */
	public void closeWindow(String handle) {
		driver.switchTo().window(handle).close();
	}

	/**
	 * return text based on locator
	 * 
	 * @param locator
	 * @return
	 */
	public String getText(By locator) {
		return findElement(locator).getText();
	}

	/**
	 * select drop-down value
	 * 
	 * @param locator
	 * @param text
	 */
	public void selectDropdownelement(By locator, String text) {
		new Select(findElement(locator)).selectByVisibleText(text);
	}

	/**
	 * return true if element present
	 * @param locator
	 * @return
	 */
	public boolean isElementPresent(By locator) {
		try {
			waitForPresenceOfElementLocatedForSeconds(locator, 3, 1);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * hover on given element
	 * 
	 * @param locator
	 * @throws InterruptedException
	 */
	public void hoverToElement(By locator) throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(findElement(locator)).build().perform();
		Thread.sleep(500);
	}

	/**
	 * wait for element to be disappeared in specified time
	 * 
	 * @param locator
	 */
	public void waitElementDisapperedImplicitly(final By locator, int seconds) {
		new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class).until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	/**
	 * Wait for element to be present id DOM
	 * 
	 * @param locator
	 * @param seconds
	 * @param pollTime
	 */
	public void waitForPresenceOfElementLocatedForSeconds(By locator, final int seconds, final int pollTime) {
		new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS)
				.pollingEvery(pollTime, TimeUnit.SECONDS).ignoring(WebDriverException.class)
				.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * wait for element is displayed in specified time
	 * 
	 * @param locator
	 * @param seconds
	 */
	public void waitElementDisplayedImplicitlyForSeconds(final By locator, int seconds) {
		new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(WebDriverException.class).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * wait for text to be present in specified time
	 * 
	 * @param locator
	 * @param text
	 * @param seconds
	 */
	public void waitElementTextToBePresentImplicitlyForSeconds(final By locator, final String text, int seconds) {
		new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	/**
	 * wait for element to be click-able in specified time
	 * 
	 * @param locator
	 * @param seconds
	 */
	public void waitElementToBeClickableForSeconds(final By locator, int seconds) {
		new FluentWait<WebDriver>(driver).withTimeout(seconds, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(locator));
	}
}
