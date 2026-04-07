package base;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import Utilities.common;
import io.appium.java_client.android.AndroidDriver;
import pages.addresspage;
import pages.loginpage;

public class BaseClass {
	
	public static AndroidDriver driver;
	public static common cm;
    public static loginpage lp;
    public static addresspage ap;
    public static ExtentReports extent;
    public static ExtentTest test;
	
	
	@BeforeSuite
	public void setup() throws MalformedURLException {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("reports/extent.html");
        spark.config().setReportName("Automation Report");
        spark.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(spark);
		
		
		DesiredCapabilities caps = new DesiredCapabilities();

        // Basic Configuration
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", "emulator-5554");
        caps.setCapability("appium:automationName", "UiAutomator2");

        // App Details
        caps.setCapability("appium:appPackage", "com.codezilla.direct_source_app");
        caps.setCapability("appium:appActivity", "com.codezilla.direct_source_app.SplashScreen");

        // Additional Settings
       // caps.setCapability("appium:noReset", true);
        //caps.setCapability("fullReset", false);
        caps.setCapability("appium:autoGrantPermissions", true);
       // caps.setCapability("newCommandTimeout", 300);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

        cm = new common(driver);
        lp = new loginpage(driver, cm);
        ap = new addresspage(driver, cm);
	}
	
	
	
	
	@AfterSuite
	public void teardown()

	{
		
		if(driver!=null) {	
		extent.flush();
		driver.quit();
			
		}
		
	}
}
