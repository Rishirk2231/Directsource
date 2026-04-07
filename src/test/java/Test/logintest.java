package Test;

import org.testng.annotations.Test;

import base.BaseClass;

public class logintest extends BaseClass{
	
	
	@Test(priority = -2, groups = "loginFlow")
	public void loginTest() {
		
		test = extent.createTest("Login to go to profile");
		
		try {
		lp.user();
		lp.pass();
		lp.checkbox();
		lp.submit();
		lp.skip();
		lp.gotoprofile1();
		}
		catch(Exception e) {

	        String screenshotPath = cm.takeScreenshot("loginTest");

	        test.fail("Login test case: " + e.getMessage())
	            .addScreenCaptureFromPath(screenshotPath);

	        throw e;
	    }
		
	}
	
	@Test(priority = -1, dependsOnMethods = "loginTest", groups = "loginFlow")
	public void profile() {
		
		test = extent.createTest("Edit profile and add address");
		
		try {
		lp.edit();
		ap.addAddress();
		}
		catch(Exception e) {
			
			String screenshotPath = cm.takeScreenshot("profile");

	        test.fail("Profile test case: " + e.getMessage())
	            .addScreenCaptureFromPath(screenshotPath);

	        throw e;
			
		}
		
	}
	
	@Test(priority = 0, dependsOnMethods = "profile", groups = "loginFlow")
	public void addcategory() {
		
		test = extent.createTest("Select category to cart");
		
		try {
		ap.selectCategory();
		ap.slotbask();
		ap.slot();
		ap.dates();
		ap.times();
		ap.contshop();
		//ap.check();
		}
		catch(Exception e) {
			
			String screenshotPath = cm.takeScreenshot("addcategory");

	        test.fail("Category test case: " + e.getMessage())
	            .addScreenCaptureFromPath(screenshotPath);

	        throw e;
			
		}
	}
	
	

}
