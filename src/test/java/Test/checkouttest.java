package Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelReader;
import base.BaseClass;

public class checkouttest extends BaseClass{
	
	
	@Test(dataProvider = "paymentData", dependsOnGroups = "loginFlow")
	public void checktest(String cardNumber, String expiry, String cvv, String zip) {
		
		test = extent.createTest("From cart to checkout");
		
		try {
		ap.check();
		ap.okay();
		ap.check();
		ap.next();
		ap.next();
		ap.check1();
		ap.selectAndVerifyCreditCard();
		ap.confirmed();
		ap.complete();
		ap.enterCardDetails(cardNumber, expiry, cvv, zip);
		ap.paylinkss();
		}
		catch(Exception e) {
			
			String screenshotPath = cm.takeScreenshot("checktest");

	        test.fail("Category test case: " + e.getMessage())
	            .addScreenCaptureFromPath(screenshotPath);

	        throw e;
		}
		
	}
	
	@DataProvider(name = "paymentData")
	public Object[][] getData() {
		System.out.println("DataProvider started");
	    return ExcelReader.getExcelData();
	}

}
