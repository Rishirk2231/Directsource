package base;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import Utilities.common;
import io.appium.java_client.android.AndroidDriver;
import pages.addresspage;
import pages.loginpage;

public class BaseClass {

	public static ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();
	public AndroidDriver getDriver() {
	    return driver.get();
	}
    public common cm;
    public loginpage lp;
    public addresspage ap;
    public static ExtentReports extent;
    public static ExtentTest test;

    
    
    @BeforeMethod
    @Parameters("device")
    public void setup(String device) throws MalformedURLException {

        // Extent Report
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/extent.html");
        spark.config().setReportName("Automation Report");
        spark.config().setDocumentTitle("Test Results");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        
        DesiredCapabilities caps = new DesiredCapabilities();       
        
        // COMMON CAPS
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage","com.codezilla.direct_source_app");
        caps.setCapability("appium:appActivity","com.codezilla.direct_source_app.SplashScreen");
        caps.setCapability("appium:autoGrantPermissions", true);
              
        // =========================
        // EMULATOR
        // =========================

        if(device.equalsIgnoreCase("emulator")) {

            caps.setCapability("appium:deviceName","emulator-5554");
            caps.setCapability("appium:udid", "emulator-5554");
            caps.setCapability("appium:systemPort", 8201);
            driver.set(new AndroidDriver(new URL("http://127.0.0.1:4723"), caps));
        }
        
        // =========================
        // REAL DEVICE
        // =========================

        else if(device.equalsIgnoreCase("mobile")) {

            caps.setCapability("appium:deviceName", "Redmi note 12 pro");
            caps.setCapability("appium:udid","v4kbnzf6w8hynfaa");
            caps.setCapability("appium:systemPort", 8202);
            caps.setCapability("appium:ignoreHiddenApiPolicyError", true);
            driver.set(new AndroidDriver(new URL("http://127.0.0.1:4725"), caps));
        }   
        
        // PAGE OBJECTS
        cm = new common(getDriver());
        lp = new loginpage(getDriver(), cm);
        ap = new addresspage(getDriver(), cm);

    }
  
    @AfterMethod
    public void teardown() {

        if(getDriver() != null) {
            getDriver().quit();
        }
        extent.flush();
    }
}