package pages;

import org.openqa.selenium.By;
import Utilities.common;
import io.appium.java_client.AppiumDriver;

public class loginpage{
	
	AppiumDriver driver;
    common cm;

    public loginpage(AppiumDriver driver, common cm) {
        this.driver = driver;
        this.cm = cm;
    }
	
	By user = By.id("com.codezilla.direct_source_app:id/email_id_etv");
	By pwd = By.id("com.codezilla.direct_source_app:id/password_etv");
	By submit = By.id("com.codezilla.direct_source_app:id/login_btn");
	By agree = By.id("com.codezilla.direct_source_app:id/checkbox_private_privacy");
	By skip = By.id("com.codezilla.direct_source_app:id/skip_btn");
	By gotopro = By.id("com.codezilla.direct_source_app:id/user_profile_img");
	By custname = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]");
	By mobnum = By.id("com.codezilla.direct_source_app:id/user_mobile_number");
	By emailid = By.id("com.codezilla.direct_source_app:id/user_email");
	By edit = By.id("com.codezilla.direct_source_app:id/edit_profile");
	By cname = By.id("com.codezilla.direct_source_app:id/bussiness_name_etv");
	By cname1 = By.id("com.codezilla.direct_source_app:id/bussiness_name_etv");
	By editsave = By.id("com.codezilla.direct_source_app:id/save_btn");
	
	
	public void user() {
		
		cm.username(user, "8056309858");
		
	}
	
	public void pass() {
		
		cm.password(pwd, "Rishi2231#");
	}
	
	public void checkbox() {
		
		cm.agree(agree);
		
	}
	
	public void submit() {
		
		cm.click(submit);
		
	}
	
	public void skip() {
		
		cm.skip(skip);
		
	}
	
	public void gotoprofile1() {
		cm.gotoprofile(gotopro, custname, mobnum, emailid);
	}
	
	public void edit() {
	
		cm.editprofile(edit, cname, cname1, "RishiRk123", editsave);
		
	}		

}
