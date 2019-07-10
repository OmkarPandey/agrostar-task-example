package agrostar.base.common;

import agrostar.base.helper.AmazonHelper;

public class ApplicationManager {

	private WebdriverHelper webdriverHelper;
	private Common common;
	private AmazonHelper amazonHelper;

	public static ApplicationManager getInstance() {
		return new ApplicationManager();
	}

	public WebdriverHelper getWebdriverHelper() {
		if (webdriverHelper == null) {
			webdriverHelper = WebdriverHelper.getWebdriverHelper();
		}
		return webdriverHelper;
	}

	public Common getCommon() {
		if (common == null) {
			common = new Common();
		}
		return common;
	}
	
	public AmazonHelper getAmazonHelper(){
		if(amazonHelper==null){
			amazonHelper = new AmazonHelper();
		}
		return amazonHelper;
	}
	
	public void stop(){
		if(webdriverHelper!=null)
			webdriverHelper.stop();
	}
}
