package com.try1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Scroll 
{
public static void main(String[] args) throws MalformedURLException, InterruptedException {
	DesiredCapabilities DC = new DesiredCapabilities();
	DC.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
	DC.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
	DC.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
//	DC.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.3");
	DC.setCapability(MobileCapabilityType.BROWSER_NAME, "android");
	DC.setCapability(MobileCapabilityType.HAS_TOUCHSCREEN,true);
	DC.setCapability(MobileCapabilityType.APP, "/Users/saurabhrai/Desktop/akosha-qa-universal-release.apk");
	
	AndroidDriver appiumDriver=new AndroidDriver(new URL("http://localhost:4723/wd/hub"), DC);
	Thread.sleep(3000);
	WebElement a = appiumDriver.findElement(By.id("com.akosha.directtalk:id/ed_phone_number"));
	int b = a.getText().length();
	for (int i = 0; i < b; i++) {
		appiumDriver.sendKeyEvent(67); // "KEYCODE_DEL"s
		//System.out.println(i);
    }
	a.sendKeys("9739559642");
   	appiumDriver.findElement(By.name("Next")).click();
	appiumDriver.findElement(By.name("CONFIRM")).click();
	WebDriverWait wait=new WebDriverWait(appiumDriver, 30);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.akosha.directtalk:id/view_profile")));
	appiumDriver.findElement(By.id("com.akosha.directtalk:id/landing_grid_item_icon")).click();
	appiumDriver.findElement(By.id("com.akosha.directtalk:id/tv_laundry_option_title")).click();
	//appiumDriver.findElement(By.id("com.akosha.directtalk:id/tv_date_title")).click();
	//appiumDriver.findElement(By.name("23")).click();
	/** date select */
	Thread.sleep(5000);
	 for(int x=3;x<6;x++)
	    {
	        //appiumDriver.swipe(222,460,311,496,0);
		
	    }
//	 appiumDriver.findElement(By.name("Done")).click();
}
}
