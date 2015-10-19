package com.try1;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.awt.print.Pageable;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.accessibility.AccessibleText;
import javax.swing.text.html.ImageView;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.ImageBitmap;
import com.gargoylesoftware.htmlunit.javascript.host.Notification;
import com.thoughtworks.selenium.condition.ConditionRunner.Context;

public class Login 
{
public static void main(String[] args) throws InterruptedException, IOException
{
	System.out.println("hello");
	DesiredCapabilities DC = new DesiredCapabilities();
	DC.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
	DC.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
	DC.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
 //	DC.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.3");
	DC.setCapability(MobileCapabilityType.BROWSER_NAME, "android");
	DC.setCapability(MobileCapabilityType.HAS_TOUCHSCREEN,true);
	DC.setCapability(MobileCapabilityType.APP, "/Users/saurabhrai/Desktop/helpchat_4.3_67.apk");
	
	AndroidDriver appiumDriver=new AndroidDriver(new URL("http://localhost:4723/wd/hub"), DC);
	
	Thread.sleep(3000);
	WebElement a = appiumDriver.findElement(By.id("com.akosha.directtalk:id/ed_phone_number"));
	int b = a.getText().length();
	for (int i = 0; i < b; i++) {
		appiumDriver.sendKeyEvent(67); // "KEYCODE_DEL"
		//System.out.println(i);
    }
	a.sendKeys("9739559642");
	WebElement str = appiumDriver.findElement(By.name("Next"));
	MobileElement hello= (MobileElement) str;
	hello.click();

	
	/*appiumDriver.findElement(By.name("CONFIRM")).click();
	// appiumDriver.findElement(By.linkText("No internet connection"));
    MobileElement slemet = (MobileElement) appiumDriver.findElement(By.id("com.akosha.directtalk:id/sign_in_bottom_image"));
   Point point = slemet.getLocation();
    System.out.println(point.getX()+"   "+point.getY());
		point.moveBy(20, 200);*/
	/*
	WebDriverWait wait=new WebDriverWait(appiumDriver, 30);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.akosha.directtalk:id/view_profile")));
	appiumDriver.findElement(By.id("com.akosha.directtalk:id/view_profile")).click();
	appiumDriver.findElement(By.className("android.widget.ImageView")).click();
	
	*//**taking screen short *//*
//	File scr=((TakesScreenshot)appiumDriver).getScreenshotAs(OutputType.FILE);
//	FileUtils.copyFile(scr, new File("C:\\Users\\Akosha\\workspace\\New\\screenshot\\test.png"));
	
	appiumDriver.findElement(By.name("Logout")).click();
	//appiumDriver.findElement(By.linkText("No internet connection"));    //driver.findElement(By.linkText("My toast"));
		//String str = appiumDriver.getCurrentUrl();
	//System.out.println(str);
*/	
	 appiumDriver.quit();
}
}
