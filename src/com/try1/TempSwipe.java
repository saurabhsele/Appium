package com.try1;

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


public class TempSwipe 
{
public static void main(String[] args) throws MalformedURLException, InterruptedException
{
	DesiredCapabilities dc = new DesiredCapabilities();	
	dc.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
	dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
	dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
	dc.setCapability(MobileCapabilityType.BROWSER_NAME, "android");
	dc.setCapability(MobileCapabilityType.HAS_TOUCHSCREEN, true);
	dc.setCapability(MobileCapabilityType.SUPPORTS_JAVASCRIPT, true);
	dc.setCapability(MobileCapabilityType.HAS_NATIVE_EVENTS, true);
	dc.setCapability(MobileCapabilityType.APP, "/Users/saurabhrai/Desktop/akosha-qa-universal-release.apk");
	AndroidDriver appiumDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
	Thread.sleep(3000);
	WebElement a = appiumDriver.findElement(By.id("com.akosha.directtalk:id/ed_phone_number"));
	int b = a.getText().length();
	for (int i = 0; i < b; i++) {appiumDriver.sendKeyEvent(67); }
	a.sendKeys("9739559642");
	appiumDriver.findElement(By.name("Next")).click();
	appiumDriver.findElement(By.name("CONFIRM")).click();
	appiumDriver.findElement(By.id("com.akosha.directtalk:id/ed_otp")).sendKeys("1234");
	appiumDriver.findElement(By.name("Done")).click();
	WebDriverWait wait=new WebDriverWait(appiumDriver, 30);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.akosha.directtalk:id/view_profile")));
	appiumDriver.findElement(By.name("Companies")).click();
	 WebElement element = appiumDriver.findElement(By.id("com.akosha.directtalk:id/main_content"));
	 appiumDriver.scrollTo(element.toString());
}
}
