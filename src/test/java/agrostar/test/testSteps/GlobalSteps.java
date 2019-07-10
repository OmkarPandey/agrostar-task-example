package agrostar.test.testSteps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import agrostar.base.common.WebdriverHelper;
import agrostar.test.testRunner.TestBase;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class GlobalSteps extends TestBase {

	@Before
	public void beforeScenario(Scenario scenario) throws Exception {
		scenarioObj = scenario;
		before(scenario);
	}

	/**
	 * Embed a screenshot in test report if test is marked as failed
	 */
	@After
	public void afterScenario(Scenario scenario) throws Exception {
		System.out.println("GlobalSteps afterScenario executed");
		after(scenario);
		if (scenario.isFailed()) {
			System.out.println("refresh page");
			Thread.sleep(1000);
			app.getCommon().refresh();
		}
	}

	/**
	 * before method
	 * 
	 * @param scenario
	 */
	private void before(Scenario scenario) {
		String id = scenario.getId();
		String scenarioName = scenario.getName();
		System.out.println("scenario started is \"" + scenarioName + "\" and its id is '" + id + "'");
	}

	/**
	 * after method
	 * 
	 * @param scenario
	 * @throws Exception
	 */
	private void after(Scenario scenario) throws Exception {
		String scenarioName = scenario.getName();
		System.out.println("scenario completed is \"" + scenarioName + "\" and it is " + scenario.getStatus() + "");
		if (scenario.isFailed()) {
			System.out.println("Embedding screenshot");
			takeScreenShot(scenario);
		}
	}

	/**
	 * Take simple screenshot
	 * 
	 * @param scenario
	 */
	private static void takeScreenShot(Scenario scenario) {
		try {
			System.out.println("getting screen shot...");
			byte[] screenshot = ((TakesScreenshot) WebdriverHelper.getWebdriverHelper().getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		} catch (Exception ex) {
			System.out.println("exception occured during getting screen shot " + ex);
		}
	}
}