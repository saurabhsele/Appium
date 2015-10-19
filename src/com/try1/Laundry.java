package com.try1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laundry 
{
	static AndroidDriver appiumDriver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		Laundry lu = new Laundry();
		DesiredCapabilities DC = new DesiredCapabilities();
		DC.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
		DC.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
		DC.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		//DC.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.3");
		DC.setCapability(MobileCapabilityType.BROWSER_NAME, "android");
		DC.setCapability(MobileCapabilityType.HAS_TOUCHSCREEN,true);
		DC.setCapability(MobileCapabilityType.APP, "/Users/saurabhrai/Desktop/helpchat_4.3_67.apk");
		
		 appiumDriver=new AndroidDriver(new URL("http://localhost:4723/wd/hub/"), DC);
		Thread.sleep(3000);
		
		WebElement a = appiumDriver.findElement(By.id("com.akosha.directtalk:id/ed_phone_number"));
		int b = a.getText().length();
		for (int i = 0; i < b; i++) {
			appiumDriver.sendKeyEvent(67); // "KEYCODE_DEL"s
	    }
		a.sendKeys("9902014801");
	appiumDriver.findElement(By.name("Next")).click();
    appiumDriver.findElement(By.name("CONFIRM")).click();
    
    WebDriverWait wait = new WebDriverWait(appiumDriver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Explore")));
   // appiumDriver.findElement(By.name("Close")).click();
    
    appiumDriver.findElement(By.name("Laundry")).click();
    
   
    
    appiumDriver.findElement(By.name("Schedule a pick up")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Tap to pick a time slot")));
    appiumDriver.findElement(By.name("Tap to pick a time slot")).click();
    
  lu.swipeLeft();
    
   // com.akosha.directtalk:id/time_picker_list
    
   /*
    * working perfectally 
    *  Thread.sleep(3000);
    for(int y=0;y<3;y++)
       {
           appiumDriver.swipe(100, 500, 100, 300, 1000);  
           Thread.sleep(3000);
       }*/
    
   
 /* 
  * did not work that's
  *  if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Tap to pick a time slot"))).isDisplayed())
   {
	appiumDriver.findElement(By.name("Tap to pick a time slot")).click();
	appiumDriver.findElement(By.name("6")).click();
	appiumDriver.findElement(By.name("OK")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Pickup Address")));
	appiumDriver.findElement(By.name("Pickup Address")).click();
} else{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Reschedule")));
	System.out.println("dusare loop me");
}
	}*/
	
   /* String ftext = appiumDriver.findElement(By.name("Tap to pick a time slot")).getText();
    System.out.println(ftext);*/
   
		/*
		 * Thread.sleep(3000); // String text =
		 * appiumDriver.findElement(By.xpath
		 * ("//*[@resource-id=‘com.akosha.directtalk:id/order_user_message’]"
		 * )).getText(); // System.out.println(text);
		 * appiumDriver.findElement(By.name("Tap to pick a time slot")).click();
		 * /
		 * /appiumDriver.findElement(By.xpath("//*[@text='Tap to pick a time slot']"
		 * )).click(); if (appiumDriver.findElement(By.id(
		 * "com.akosha.directtalk:id/rl_agent_message")).isEnabled()) {
		 * System.out.println(" Hi, I want to book a Laundry service "); } else
		 * { System.out.println("Welcome back"); }
		 * 
		 * 
		 * 
		 * Thread.sleep(3000);
		 * appiumDriver.findElement(By.name("Tap to pick a time slot")).click();
		 * String time =
		 * appiumDriver.findElement(By.id("com.akosha.directtalk:id/picker_year"
		 * )).getText(); System.out.println(time); //need to devlop a methode
		 * appiumDriver.findElement(By.name("Thu")).click(); //
		 * appiumDriver.findElement(By.name("10:00 AM-11:00 AM")).click();
		 * appiumDriver.findElement(By.name("OK")).click();
		 * appiumDriver.findElement(By.name("Pickup Address")).click();
		 */
	}
	  public void swipeLeft()
	    { 
	        appiumDriver.context("NATIVE_APP"); 
	        Dimension size = appiumDriver.manage().window().getSize(); 
	        int startx = (int) (size.width * 0.8); 
	        int endx = (int) (size.width * 0.20); 
	        int starty = size.height / 2; 
	        appiumDriver.swipe(startx, starty, endx, starty, 1000);
	    }
}
