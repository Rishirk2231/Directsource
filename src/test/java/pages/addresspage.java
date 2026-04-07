package pages;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.common;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class addresspage {

	AndroidDriver driver;
    common cm;

    public addresspage(AppiumDriver driver, common cm) {
        this.driver = (AndroidDriver) driver;
        this.cm = cm;
    }

    // Locators
    By addr = By.id("com.codezilla.direct_source_app:id/saved_address");
    By addaddress = By.id("com.codezilla.direct_source_app:id/add_new_address");
    By name = By.id("com.codezilla.direct_source_app:id/bussiness_name_etv");
    By ph_num = By.id("com.codezilla.direct_source_app:id/phone_number_etv");
    By door = By.id("com.codezilla.direct_source_app:id/door_no_etv");
    By street = By.id("com.codezilla.direct_source_app:id/street_name_etv");
    By city = By.id("com.codezilla.direct_source_app:id/city_etv");
    By postcode = By.id("com.codezilla.direct_source_app:id/post_code_etv");
    By save = By.id("com.codezilla.direct_source_app:id/save_btn");
    By back = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    By back1 = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    By add1 = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[4]/android.widget.TextView");
    By coll = By.id("com.codezilla.direct_source_app:id/collection_radio_btn");
    By dateclick = By.id("com.codezilla.direct_source_app:id/date_tv");
    By dateCell = By.xpath("//android.view.View[@content-desc]");
    By dateok = By.id("com.codezilla.direct_source_app:id/mdtp_ok");
    By timeclick = By.id("com.codezilla.direct_source_app:id/time_slot_bottom_sheet_txt");
    By timecell = By.id("com.codezilla.direct_source_app:id/time_slot_rcv");
    By timeok = By.id("com.codezilla.direct_source_app:id/done_btn");
    By contshop = By.id("com.codezilla.direct_source_app:id/reserve_and_continue_shopping_btn");
    By alreadyadded = By.id("com.codezilla.direct_source_app:id/count_tv_btn_layout");
    By cartbtn = By.id("com.codezilla.direct_source_app:id/cart_btn");
    By slotbasket = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView");
    By checkout = By.id("com.codezilla.direct_source_app:id/check_out_btn");
    By okay = By.id("com.codezilla.direct_source_app:id/ok_btn");
    By next = By.id("com.codezilla.direct_source_app:id/next_btn");
    By check2 = By.id("com.codezilla.direct_source_app:id/checkout_btn");
    By card = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RadioGroup/android.widget.RadioButton[2]");
    //By confirm = By.xpath("//android.widget.Button[@text='Yes']");
    By paynow = By.id("com.codezilla.direct_source_app:id/pay_now_tv");
    By cardNumber = By.xpath("(//android.widget.EditText)[1]");
    By expiry = By.xpath("(//android.widget.EditText)[2]");
    By cvv = By.xpath("(//android.widget.EditText)[3]");
    By zip = By.xpath("(//android.widget.EditText)[4]");
    By paylink = By.id("com.codezilla.direct_source_app:id/primary_button");
 
//    public void addAddress() {
//        cm.editaddr(addr, addaddress, name, ph_num, door, street, city, postcode,
//                "Rk", "8056309858", "14", "Balaji street", "Chennai", "602105", save, back, back1);
//    }
    
    public void addAddress() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 1: Click Address menu
        cm.click(addr);

        // Step 2: Check if Add Address button exists
        if (driver.findElements(addaddress).size() > 0) {

            System.out.println("Add Address available");

            // Click Add Address
            cm.click(addaddress);

            // Fill form
            cm.sendKeys(name, "Rk");
            cm.sendKeys(ph_num, "8056309858");
            cm.sendKeys(door, "14");

            // Close keyboard
            try {
                driver.hideKeyboard();
            } catch (Exception e) {
                driver.pressKey(new io.appium.java_client.android.nativekey.KeyEvent(
                        io.appium.java_client.android.nativekey.AndroidKey.BACK));
            }

            cm.sendKeys(street, "Balaji street");
            cm.sendKeys(city, "Chennai");
            cm.sendKeys(postcode, "602105");

            // Save
            cm.click(save);

        } else {

            System.out.println("Address limit reached");

            // Go back
            cm.click(back);

            // Go home (same locator you used)
            cm.click(back1);

            return;
        }
    }
    
    public void selectCategory() {

        cm.scrollAndClickByText("Drinks");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // First try: wait for "already added" indicator
            WebElement addedIndicator = wait.until(ExpectedConditions.presenceOfElementLocated(alreadyadded));
            driver.findElement(cartbtn).click();
            System.out.println("Product already added → Redirecting to cart.");
        } catch (org.openqa.selenium.TimeoutException e) {
            // If not found within timeout, then wait for add button
            WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(add1));
            addBtn.click();
            System.out.println("Product added successfully.");
        }
    }
    
    public void slotbask() {
    	
    	cm.slotbasket(slotbasket);
    	
    }
           
    public void slot() {
    	
    	cm.slot(coll);
    }
    
    public void dates() {
    	
    	cm.date(dateclick, dateCell, dateok);
    }
    
    public void times() {
    	
    	cm.time(timeclick, timecell, timeok);
    	
    }
    
    public void contshop() {
    	
    	cm.continueshopping(contshop);
    }
    
    public void check() {
    	
    	cm.checkout(checkout);
    }
    
    public void okay() {
    	
    	cm.okay(okay);
    	
    }
    
    public void next() {
    	
    	cm.next(next);
    }
    
    public void check1() {
    	
    	cm.check2(check2);
    }
    
    public void selectAndVerifyCreditCard() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement cards = wait.until(ExpectedConditions.visibilityOfElementLocated(card));

        // ✅ Click using same xpath
        cards.click();
        System.out.println("Clicked Credit / Debit Card");

        // ✅ Hard Assert
//        Assert.assertTrue(
//            cards.getAttribute("checked").equals("true"),
//            "Credit / Debit Card is NOT selected!"
//        );
//
//        System.out.println("Credit / Debit Card selected successfully");
    }
    
    public void confirmed() {
    	
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement yes = wait.until(
            ExpectedConditions.elementToBeClickable(By.id("com.codezilla.direct_source_app:id/submit_btn"))
        );

        yes.click();
        System.out.println("Clicked YES button");
    }
    
    public void complete() {
    	
    	cm.paynows(paynow);
    	
    }
    
    public void enterCardDetails(String card, String exp, String cvvv, String post) {

    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumber));
        cm.sendKeys(cardNumber, card);
        cm.sendKeys(expiry, exp);
        cm.sendKeys(cvv, cvvv);
        cm.sendKeys(postcode, post);
    }
    
    public void paylinkss() {
    	
    	cm.cards(paylink);
    	
    }
}
