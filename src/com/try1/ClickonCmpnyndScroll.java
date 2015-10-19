package com.try1;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ClickonCmpnyndScroll 
{
public static void main(String[] args) throws MalformedURLException, InterruptedException 
{
DesiredCapabilities dc = new DesiredCapabilities();	
dc.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
dc.setCapability(MobileCapabilityType.BROWSER_NAME, "android");
dc.setCapability(MobileCapabilityType.HAS_TOUCHSCREEN, true);
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
MobileElement element = (MobileElement) appiumDriver.findElement(By.id("com.akosha.directtalk:id/main_content"));
Point center = element.getCenter();
System.out.println("center"+center);

Point location = element.getLocation();
System.out.println("location :"+location);

Dimension size = element.getSize();
System.out.println("size : "+size);
int height = size.height;											
int width = size.width;
System.out.println("height"+height);
System.out.println("width"+width);

Thread.sleep(7000);

for (int i = 0; i < 3; i++) {
	
	appiumDriver.swipe(200, 900, 200, 300, 1000);
	//element.swipe(SwipeElementDirection.DOWN, offsetFromStartBorder, offsetFromEndBorder, 0);
		}

/*TouchAction action = new TouchAction(appiumDriver); 
Point upperleft = element.getLocation(); 
Dimension dimensions = element.getSize(); 
Point sliderLocation = new Point(upperleft.getX() + dimensions.getWidth()/2, upperleft.getY() + dimensions.getHeight()/2); 
action.press(sliderLocation.getX(), sliderLocation.getY()).waitAction(200).moveTo(sliderLocation.getX()+(sliderLocation.getX()-1), sliderLocation.getY()).release().perform();
*/
/*for down
 * int offset=1;
Point p = element.getCenter();
Point location = element.getLocation();
Dimension size = element.getSize();
appiumDriver.swipe(p.getX(), location.getY()+ size.getHeight() + offset, p.getX() , location.getY(), 5);*/

/**org.openqa.selenium.WebDriverException*//*
MobileElement element = (MobileElement) appiumDriver.findElement(By.className("android.widget.RelativeLayout"));
int offset=1;
Point p = element.getCenter();
Point location = element.getLocation();
Dimension size = element.getSize();
appiumDriver.swipe(p.getX(), location.getY(), p.getX() - offset, location.getY()+size.getHeight(), 0);*/
/*int time;
void swipeUpElement( appiumDriver, element , time)
{
    int topY = element.getLocation().getY();
    int bottomY = topY + element.getSize().getHeight();
    int centerX = element.getLocation().getX() + (element.getSize().getWidth()/2)
    appiumDriver.
    //swipe(centerX, bottomY, centerX, topY, time);
}*/


//DOWN {
//    void swipe(AppiumDriver driver, MobileElement element, int duration) {
//        int offset = 1;
//        Point p = element.getCenter();
//        Point location = element.getLocation();
//        Dimension size = element.getSize();
//        driver.swipe(p.getX(), location.getY(), p.getX() - offset, location.getY() + size.getHeight(), duration);
//    }
//},

		  System.out.println(1);
		  /**not working*/
//	  Thread.sleep(7000);
//	MobileElement element = (MobileElement) appiumDriver.findElement(By.className("android.widget.TextView"));
//	
//	for (int i = 0; i < 3; i++) {
//		element.swipe(SwipeElementDirection.UP, 88,697, 0);context("NATIVE_APP");
//		}
		 /**swipe left to right
		  * http://stackoverflow.com/questions/28234045/appium-swipe-not-working-on-the-android-device-through-java-code*/ 
//		  appiumDriver.context("NATIVE_APP");
//		     Dimension size = appiumDriver.manage().window().getSize();
//		     System.out.println(size);
//		     int startX = (int)(size.width * 0.10);
//		     int endX = (int)(size.width * 0.80);
//		     int startY = size.height/2;
//		     appiumDriver.swipe(startX, startY, endX, startY, 1000);
		  
/**
 * trying down*/

		  
		  
		  
		  
		  
}
}
