package com.try1;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.eclipse.jetty.io.ByteArrayEndPoint;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddNewAddress 
{
public static void main(String[] args) throws MalformedURLException, InterruptedException 
{
	DesiredCapabilities DC = new DesiredCapabilities();
	DC.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
	DC.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
	DC.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
	//DC.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.3");
	DC.setCapability(MobileCapabilityType.BROWSER_NAME, "android");
	DC.setCapability(MobileCapabilityType.HAS_TOUCHSCREEN,true);
	DC.setCapability(MobileCapabilityType.APP, "/Users/saurabhrai/Desktop/helpchat_4.3_67.apk");
	
	AndroidDriver appiumDriver=new AndroidDriver(new URL("http://localhost:4723/wd/hub/"), DC);
	
	 System.out.println("done");
	 
	Thread.sleep(3000);
	MobileElement a = (MobileElement) appiumDriver.findElement(By.id("com.akosha.directtalk:id/ed_phone_number"));
	int b = a.getText().length();
	for (int i = 0; i < b; i++) {
		appiumDriver.sendKeyEvent(67); // "KEYCODE_DEL"
		//System.out.println(i);
    }
	a.sendKeys("9902014801");
	
	//a.sendKeys("9739559642");
	appiumDriver.findElement(By.name("Next")).click();
	appiumDriver.findElement(By.name("CONFIRM")).click();
	//appiumDriver.findElement(By.id("com.akosha.directtalk:id/ed_otp")).sendKeys("1234");
	appiumDriver.findElement(By.name("Done")).click();
	WebDriverWait wait=new WebDriverWait(appiumDriver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.akosha.directtalk:id/view_profile")));
    appiumDriver.findElement(By.id("com.akosha.directtalk:id/view_profile")).click();
    //appiumDriver.findElement(By.className("android.widget.ImageView")).click();
    appiumDriver.findElement(By.name("Saved addresses")).click();
   // Thread.sleep(3000);
    appiumDriver.findElement(By.name("Add New Address")).click();
   // appiumDriver.findElement(By.name(""))
    	
  /*  List home = appiumDriver.findElements(By.id("com.akosha.directtalk:id/tv_address_type"));
   for (int j = 0; j < home.size(); j++) {
    	appiumDriver.findElement(By.name("DELETE")).click();
        appiumDriver.findElement(By.id("com.akosha.directtalk:id/tv_alert_negative")).click();
        appiumDriver.swipe(200, 900, 200, 300, 1000);
	}*/
   
/*     String first_lastname = appiumDriver.findElement(By.id("com.akosha.directtalk:id/name")).getText();
     System.out.println(first_lastname);
     // ---- edit button ----
     appiumDriver.findElement(By.name("EDIT")).click();
     appiumDriver.findElement(By.className("android.widget.ImageButton")).click();
     
     // ---- delete ---
     appiumDriver.findElement(By.name("DELETE")).click();
     appiumDriver.findElement(By.id("com.akosha.directtalk:id/tv_alert_negative")).click();
     
     // set as default 
     if ( !appiumDriver.findElement(By.name("SET AS DEFAULT")).isSelected() )
     {
          appiumDriver.findElement(By.name("SET AS DEFAULT")).click();
          String deft = appiumDriver.findElement(By.name("DEFAULT")).getText();
          System.out.println(deft);
         // Assert.assertEquals(deft, expected);
     } */
     
     
   // appiumDriver.findElement(By.id("com.akosha.directtalk:id/submit_button_add_address")).click();
    //First name
  //  appiumDriver.findElement(By.name("Save")).click();
  // WebElement text =  appiumDriver.findElement(By.id("com.akosha.directtalk:id/et_first_name"));
  
  //String he = text.getTagName();//print the value : android.widget.TextView
   // String he = text.getCssValue("color");
  //appiumDriver.findElementByAndroidUIAutomator(By.)
   // System.out.println("print the value : " +he);   
	
}
}
