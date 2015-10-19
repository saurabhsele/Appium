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
import org.testng.Assert;


public class FAQicon {

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
		
		//a.sendKeys("9739559642");
		appiumDriver.findElement(By.name("Next")).click();
		appiumDriver.findElement(By.name("CONFIRM")).click();
		appiumDriver.findElement(By.id("com.akosha.directtalk:id/ed_otp")).sendKeys("1234");
		appiumDriver.findElement(By.name("Done")).click();
		WebDriverWait wait=new WebDriverWait(appiumDriver, 30);
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.akosha.directtalk:id/view_profile")));
	    appiumDriver.findElement(By.name("Shopping")).click();
	    appiumDriver.findElement(By.name("Need help? Chat with our expert")).click();
	    appiumDriver.findElement(By.id("com.akosha.directtalk:id/chat_questions")).click();
	    String str = appiumDriver.findElement(By.id("com.akosha.directtalk:id/chat_edit_text")).getText();
	    Assert.assertEquals("Suggested questions", str);
	    
	}

}
