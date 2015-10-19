package com.try1;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SchedulePickUp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities DC = new DesiredCapabilities();
		DC.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
		DC.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
		DC.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
//		DC.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.3");
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
		List<MobileElement> d = appiumDriver.findElements(By.id("com.akosha.directtalk:id/tv_laundry_option_title"));
		d.get(4).swipe(SwipeElementDirection.DOWN, 5000);
	
		//appiumDriver.findElement(By.id("com.akosha.directtalk:id/tv_date_title")).click();
		//appiumDriver.findElement(By.name("23")).click();
		/** date select */
//		Thread.sleep(5000);
//		 for(int x=3;x<6;x++)
//		    {
//		        appiumDriver.swipe(95,377,191,476,0);  
//		    }
//		 appiumDriver.findElement(By.name("Done")).click();
	 System.out.println("start");	
	// for (int i = 0; i < args.length; i++) {
		 appiumDriver.swipe(0,436,76,436,4000);
//	}
	
	 
//		TouchAction action = new TouchAction(appiumDriver);
//		action.press(60,440).moveTo(220,440).release().perform();
			System.out.println("end");
		/**throwing exception org.openqa.selenium.WebDriverException */
//		for(int x=3;x<6;x++)
//        {
//		List<MobileElement> elements=appiumDriver.findElements(By.id("com.akosha.directtalk:id/tv_address")); 
//		//elements.get(0).swipe(SwipeElementDirection.LEFT, 5000);
//         }
		/**add address*/
//		appiumDriver.findElement(By.id("com.akosha.directtalk:id/ll_content")).click();
//		appiumDriver.findElement(By.id("com.akosha.directtalk:id/et_first_name")).sendKeys("saurabbh");
//		appiumDriver.findElement(By.id("com.akosha.directtalk:id/et_last_name")).sendKeys("rai");
//		appiumDriver.findElement(By.id("com.akosha.directtalk:id/et_address")).sendKeys("# 31 silkboard");
//		appiumDriver.findElement(By.id("com.akosha.directtalk:id/et_state")).sendKeys("Karnataka");
//		
//		appiumDriver.findElement(By.id("com.akosha.directtalk:id/et_locality")).sendKeys("silk board");
//		
//		appiumDriver.findElement(By.id("com.akosha.directtalk:id/et_city")).sendKeys("bangalore");
//		
//		appiumDriver.findElement(By.id("com.akosha.directtalk:id/et_pin_code")).sendKeys("560068");
//		appiumDriver.findElement(By.id("com.akosha.directtalk:id/et_tag")).sendKeys("nothing");
//		appiumDriver.findElement(By.id("com.akosha.directtalk:id/btn_save_address")).click();
				
	}

}
