package com.try1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Otp 
{
	public static AndroidDriver appiumDriver;
	public static void pressBackButtonOfDevice() {
		appiumDriver.sendKeyEvent(4);

	}
		public static void main(String[] args) throws MalformedURLException, InterruptedException 
		{
			Otp otp = new Otp();
			DesiredCapabilities DC = new DesiredCapabilities();
			DC.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
			DC.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
			DC.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
			//DC.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.3");
			DC.setCapability(MobileCapabilityType.BROWSER_NAME, "android");
			DC.setCapability(MobileCapabilityType.HAS_TOUCHSCREEN,true);
			DC.setCapability(MobileCapabilityType.APP, "/Users/saurabhrai/Desktop/akosha-staging-universal-release.apk");
			
		 appiumDriver=new AndroidDriver(new URL("http://localhost:4723/wd/hub/"), DC);
			
			
			 System.out.println("done");
			// appiumDriver.navigate().back();
			 otp.pressBackButtonOfDevice();
			 appiumDriver.findElement(By.name("Messaging")).click();
}
	}
