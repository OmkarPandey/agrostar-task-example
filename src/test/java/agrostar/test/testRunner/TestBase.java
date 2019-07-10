package agrostar.test.testRunner;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import agrostar.base.common.ApplicationManager;
import agrostar.base.common.Common;

import cucumber.api.Scenario;


/**
 * Base class for Start and Close browser
 * 
 * @author Omkar
 * 
 */
public class TestBase {

	protected static Logger log = Logger.getLogger("TEST");
	protected static Scenario scenarioObj;
	protected static ApplicationManager app;
	protected static Common common;
	private static Properties prop;

	/**
	 * setup environment and start browser
	 * 
	 * @throws IOException
	 */
	@BeforeClass
	public static void setUp() throws IOException {
		setup();
		loadBrowserDriver();

		app = ApplicationManager.getInstance();
		try {
			System.out.println("Setup----------");
			WebDriver driver = app.getWebdriverHelper().getDriver();
			System.out.println("Setup2----------");
			Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
			System.out.println("Setup Complete " + driver + ", Browser Name: " + caps.getBrowserName());
			//app.getCommon().maximizeWindow();
			app.getCommon().setImplicitWait(10);
			
		} catch (Exception ex) {
			System.out.println("exception occured in setUp() " + ex);
		}
		common = app.getCommon();
	}

	/**
	 * close browser session
	 */
	public static void tearDown() {
		try {
			WebDriver driver = app.getWebdriverHelper().getDriver();
			Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
			System.out.println("Tear down start " + driver + ", Browser Name: " + caps.getBrowserName());
		} catch (Exception ex) {
			System.out.println("exception occured in tearDown()");
		}
		try {
			app.stop();
		} catch (Exception ex) {
			System.out.println("exception >>> " + ex);
		}
		System.out.println("tear down end");
	}

	/**
	 * load browser specific driver
	 */
	private static void loadBrowserDriver() {
		if (System.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		} else if (System.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("", "");
		} else if (System.getProperty("browser").equalsIgnoreCase("internetExplorer")) {
			System.setProperty("", "");
		}
		System.out.println(System.getProperty("browser") + " browser driver has been loaded");
	}

	/**
	 * load property file
	 * 
	 * @throws IOException
	 */
	private static void setup() throws IOException {
		String configFile = "./src/main/resources/config.properties";
		prop = new Properties(System.getProperties());
		prop.load(new FileReader(configFile));
		System.setProperties(prop);

		String browser = System.getProperty("browser");
		String platform = System.getProperty("platform");
//		String baseUrl = System.getProperty("baseUrl");
//		String userEmail = System.getProperty("userEmail");
//		String password = System.getProperty("password");

		System.out.println("Browser = " + browser + ", Platform = " + platform);

		System.out.println("----setup starts----");

		if (browser != null)
			System.setProperty("browser", browser);
		if (platform != null)
			System.setProperty("platform", platform);
		if (platform != null)
			System.setProperty("platform", platform);
	}
}
