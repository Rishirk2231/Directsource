package Utilities;

import java.io.File;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.interactions.PointerInput;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class common{
	
	public AndroidDriver driver;
	
	 public common(AppiumDriver driver) {
	        this.driver = (AndroidDriver) driver;
	    }
	
	public void username(By loc, String uname) {
		long start = System.currentTimeMillis();
		//System.out.println(driver.getPageSource());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
	    element.sendKeys(uname);
	    long end = System.currentTimeMillis();
	    System.out.println("Username field action took: " + (end - start) + " ms");
	    
	}
	
	public void password(By loc, String pwd) {
		long start = System.currentTimeMillis();
		driver.findElement(loc).sendKeys(pwd);
		long end = System.currentTimeMillis();
		System.out.println("Password field action took: " + (end - start) + " ms");
	}
	
	public void click(By loc) {
		
		long start = System.currentTimeMillis();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loc));
	    element.click();
	    long end = System.currentTimeMillis();
	    System.out.println("Click action took: " + (end - start) + " ms");
	}
	
	public void agree(By loc) {
		
		long start = System.currentTimeMillis();
		WebElement checkbox = driver.findElement(loc);

		if(!checkbox.isSelected()) {
		    checkbox.click();
		    System.out.println("Checkbox clicked");
		}
		else {
			
			System.out.println("Checkbox already clicked");
			
		}
		long end = System.currentTimeMillis();
		System.out.println("Click action took: " + (end - start) + " ms");
	}

	public void skip(By loc) {
		long start = System.currentTimeMillis();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));		
	    WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(loc));
	    element1.click();
	    long end = System.currentTimeMillis();
	    System.out.println("Skip action took: " + (end - start) + " ms");
	}
	
	public void gotoprofile(By loc, By loc1, By loc2, By loc3) {
		long start = System.currentTimeMillis();
		driver.findElement(loc).click();
		String custname = driver.findElement(loc1).getText();
		System.out.println(custname);
		String mobnum = driver.findElement(loc2).getText();
		System.out.println(mobnum);
		String emailid = driver.findElement(loc3).getText();
		System.out.println(emailid);
		long end = System.currentTimeMillis();
		System.out.println("Profile action took: " + (end - start) + " ms");
	}
	
	
	public void editprofile(By loc, By loc1, By loc2, String cname, By loc3) {
		
		long start = System.currentTimeMillis();
		driver.findElement(loc).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loc1));
		element.click();
		element.clear();
		driver.findElement(loc2).sendKeys(cname);
		driver.hideKeyboard();
		driver.findElement(loc3).click();
		long end = System.currentTimeMillis();
		System.out.println("Edit profile:" + (end - start) + "ms");
			
	}
	
	public void sendKeys(By loc, String value) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(loc)).sendKeys(value);
	}
	
//	public void editaddr(By loc, By loc1, By loc2, By loc3, By loc4, By loc5, By loc6, By loc7, String cname, String mob, String door, String st, String city, String pc, By loc8, By loc9, By loc10) {
//		
//		long start = System.currentTimeMillis();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement waitaddr = wait.until(ExpectedConditions.elementToBeClickable(loc));
//		waitaddr.click();
//		try {
//		    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		    wait1.until(ExpectedConditions.elementToBeClickable(loc1)).click();
//		} catch (Exception e) {
//		    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		    wait2.until(ExpectedConditions.elementToBeClickable(loc9)).click();
//		}
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(loc2)).sendKeys(cname);
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(loc3)).sendKeys(mob);
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(loc4)).sendKeys(door);
//	    try {
//	        driver.hideKeyboard();
//	    } catch (Exception e) {
//	        driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(
//	                io.appium.java_client.android.nativekey.AndroidKey.BACK));
//	    }
//
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(loc5)).sendKeys(st);
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(loc6)).sendKeys(city);
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(loc7)).sendKeys(pc);
//	    wait.until(ExpectedConditions.elementToBeClickable(loc8)).click();
//	    wait.until(ExpectedConditions.elementToBeClickable(loc9)).click();
//	    wait.until(ExpectedConditions.elementToBeClickable(loc10)).click();
//		long end = System.currentTimeMillis();
//		System.out.println("Edit address:" + (end - start) + "ms");
//		
//	}
	
	public void scrollAndClickByText(String text) {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    for (int i = 0; i < 6; i++) {

	        // ✅ Step 1: Check if element already visible
	        if (driver.findElements(By.xpath("//*[contains(@text,'" + text + "')]")).size() > 0) {

	            WebElement el = wait.until(
	                ExpectedConditions.elementToBeClickable(
	                    By.xpath("//*[contains(@text,'" + text + "')]")
	                )
	            );

	            el.click();
	            System.out.println("Clicked: " + text);
	            return;
	        }

	        // ✅ Step 2: Safe swipe (middle → avoid refresh)
	        org.openqa.selenium.Dimension size = driver.manage().window().getSize();

	        int startX = size.width / 2;
	        int startY = (int) (size.height * 0.7);
	        int endY = (int) (size.height * 0.4);

	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence swipe = new Sequence(finger, 1);

	        swipe.addAction(finger.createPointerMove(Duration.ZERO,
	                PointerInput.Origin.viewport(), startX, startY));
	        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700),
	                PointerInput.Origin.viewport(), startX, endY));
	        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	        driver.perform(Collections.singletonList(swipe));

	        // ✅ Step 3: Wait after swipe (important)
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }

	    // ❌ If not found after scroll attempts
	    throw new RuntimeException("Element not found after scrolling: " + text);
	}
	
	public void addpro(By loc) {
		
		long start = System.currentTimeMillis();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loc));
	    element.click();
	    long end = System.currentTimeMillis();
		System.out.println("Edit profile:" + (end - start) + "ms");
		
	}
	
	public void slot(By coll) {
		
		long start = System.currentTimeMillis();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(coll));
	    element1.click();
	    long end = System.currentTimeMillis();
		System.out.println("Edit profile:" + (end - start) + "ms");
		
	}
	
	public void date(By loc, By datelocator, By dateok) {
		
		driver.findElement(loc).click();
		
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(datelocator));

	    
	    List<WebElement> dates = driver.findElements(datelocator);
	    for (WebElement date : dates) {
	        if (date.isEnabled()) {
	            System.out.println("Selecting date: " + date.getAttribute("content-desc"));
	            date.click();
	            break;
	        }
	    }
	    
	    WebElement ok = driver.findElement(dateok);
	    ok.click();
	    
   }
	
	public void time(By loc, By timeselect, By done) {
		
		
		driver.findElement(loc).click();
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(timeselect));
	    
	    List<WebElement> times = driver.findElements(timeselect);
	    for (WebElement time : times) {
	        if (time.isEnabled()) {
	            System.out.println("Selecting time: " + time.getText());
	            time.click();
	            break;
	        }
	    }
	    
	    WebElement done1 = driver.findElement(done);
	    done1.click();
		
	}
	
	public void continueshopping(By loc) {
		
		driver.findElement(loc).click();
			
	}
	
	public void slotbasket(By loc) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loc));
		element.click();	
	}
	
    public void checkout(By loc) {
		
    	try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loc));
            element.click();
            System.out.println("Checkout clicked successfully");

        } catch (Exception e) {
            System.out.println("Checkout button not found. App might have restarted.");
        }
	}
    
    public void okay(By loc) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loc));
    	element.click();
    	
    }
    
     public void next(By loc) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loc));
    	element.click();
    	
    }
     
    public void check2(By loc) {
     	
     	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
     	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loc));
     	element.click(); 	
     }
    
//    public void cardyes(By loc) {
//    	
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        try {
//            // Wait for popup
//            WebElement yes = wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
//
//            // Click Yes
//            yes.click();
//
//            System.out.println("Clicked YES on popup");
//
//        } catch (Exception e) {
//            System.out.println("Popup not appeared or already handled");
//        }
//    	
//    }
    
    public String takeScreenshot(String testName) {
    	
    	String path = System.getProperty("user.dir") + "/Screenshot" + testName + ".png";
    	
    	try {
    	TakesScreenshot tks = (TakesScreenshot) driver;
    	File temp = tks.getScreenshotAs(OutputType.FILE);
    	File dest = new File(path);
    	FileUtils.copyFile(temp,dest);
    	}
    	catch(Exception e) {
    		
    		System.out.println("Failed Screenshot" + e.getMessage());
    		
    	}
    	
    	return path;
    }
    
       public void paynows(By loc) {
     	
     	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
     	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loc));
     	element.click(); 	
     }
       
       public void cards(By loc) {
    	   
    	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
           WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loc));
           element.click(); 
    	   
       }
}
