package com.try1;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
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


public class Trial
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
		DC.setCapability(MobileCapabilityType.APP, "/Users/saurabhrai/Desktop/akosha-qa-universal-release.apk");
		
		AndroidDriver appiumDriver=new AndroidDriver(new URL("http://localhost:4723/wd/hub"), DC);
		
		System.out.println("done");
		Thread.sleep(3000);
		WebElement a = appiumDriver.findElement(By.id("com.akosha.directtalk:id/ed_phone_number"));
		int b = a.getText().length();
		for (int i = 0; i < b; i++) {
			appiumDriver.sendKeyEvent(67); // "KEYCODE_DEL"
			//System.out.println(i);
	    }
		a.sendKeys("9739559642");
		System.out.println(b);
		//a.sendKeys("9739559642");
		appiumDriver.findElement(By.name("Next")).click();
		appiumDriver.findElement(By.name("CONFIRM")).click();
		appiumDriver.findElement(By.id("com.akosha.directtalk:id/ed_otp")).sendKeys("1234");
		appiumDriver.findElement(By.name("Done")).click();
		WebDriverWait wait=new WebDriverWait(appiumDriver, 30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.akosha.directtalk:id/view_profile")));
		//List<MobileElement> d = appiumDriver.findElements(By.id("com.akosha.directtalk:id/landing_grid_item_text"));
	
//	  WebDriverWait wait1=new WebDriverWait(appiumDriver, 70);
//		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("com.akosha.directtalk:id/progressBar1")));
	  
		//String app = appiumDriver.findElement(By.id("com.akosha.directtalk:id/place_name")).getText();
		//String app = appiumDriver.findElement(By.name("BCD Travels")).getText();
		//System.out.println(app);
		/**try with text name*/
//		
//	   MobileElement element = (MobileElement) appiumDriver.findElement(By.name("BCD Travels"));
//	   System.out.println(element.getText());
//	   for (int i = 0; i < 4; i++) {
//		   element.swipe(SwipeElementDirection.DOWN, 4);
//	}
	    
	MobileElement    element=(MobileElement) appiumDriver.findElement(By.className("android.support.v7.widget.RecyclerView"));
	for (int i = 0; i < 3; i++) {
		element.swipe(SwipeElementDirection.DOWN, 0 , 370 , 0);
		
	} 
	    
	    
	  /**working for search nearby*/
	   // appiumDriver.findElement(By.name("Food, ATM, fuel and much more...")).click();	
	//	  System.out.println(1);
//	  Thread.sleep(7000);
//	MobileElement element = (MobileElement) appiumDriver.findElement(By.className("android.widget.LinearLayout"));
//	
//	for (int i = 0; i < 3; i++) {
//		element.swipe(SwipeElementDirection.DOWN, 0, 669 , 0);
//		
//	}
//	  
	  
	  
//	  
//	  ((MobileElement) element).swipe(SwipeElementDirection.UP, 20, -50, 30);
	  
	  
	  
	  /**old trial*/
////	   MobileElement element = (MobileElement)
//	    e.swipe(SwipeElementDirection.UP, 0, -50, 10);
////	 
//	// e.swipe(direction, offsetFromStartBorder, offsetFromEndBorder, duration);
//	   
	    
	    
	    
	    
		
	}
}
