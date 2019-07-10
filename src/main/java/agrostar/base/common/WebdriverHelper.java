package agrostar.base.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * WebdriverHelper class is responsible to create session
 * @author Omkar
 *
 */
public class WebdriverHelper {

	private static WebdriverHelper webdriverHelper;
	private WebDriver driver;
	private String sessionID;

	/**
	 * private constructor, so that we could create one driver object
	 */
	private WebdriverHelper() {
	
			if (getBrowser() != null && getBrowser().equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				sessionID = ((ChromeDriver) driver).getSessionId().toString();
			} else if (getBrowser() != null && getBrowser().equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				sessionID = ((FirefoxDriver) driver).getSessionId().toString();
			} else if (getBrowser() != null && getBrowser().equalsIgnoreCase("internet explorer")) {
				driver = new InternetExplorerDriver();
				sessionID = ((InternetExplorerDriver) driver).getSessionId().toString();
			}
		
		System.out.println("Browser = " + getBrowser() + ", SessionID = " + sessionID);
		System.setProperty("sessionID", sessionID);
	}

	/**
	 * static method for access WebdriverHelper outside the class
	 * 
	 * @return
	 */
	public static WebdriverHelper getWebdriverHelper() {
		if (webdriverHelper == null)
			webdriverHelper = new WebdriverHelper();
		return webdriverHelper;
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
	 * get browser from configuration file
	 * 
	 * @return
	 */
	private String getBrowser() {
		return System.getProperty("browser");
	}

	/**
	 * stop or close current execution
	 */
	public void stop() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
