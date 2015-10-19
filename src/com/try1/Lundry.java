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
import org.testng.Assert;


public class Lundry 
{
	/*AndroidDriver appiumDriver;
	   public  String get_chat_title()
		{
		   WebElement value = appiumDriver.findElement(By.name("Helpchat"));
		   String text = value.getText();
		   return text;
		}	*/
	  
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
    appiumDriver.findElement(By.name("Laundry")).click();
    //appiumDriver.findElement(By.name("Chat with our laundry experts")).click();
   List< WebElement> element=appiumDriver.findElements(By.className("android.widget.TextView"));
   
     System.out.println(element.get(2).getText());
    WebElement value = appiumDriver.findElement(By.className("//*[@resource-id='com.akosha.directtalk:id/title']"));
    
   String text = value.getText();
   System.out.println("-----------------------------------   "+text+"    --------------------------------------------");

   
   
   //List<MobileElement> d = appiumDriver.findElements(By.id("com.akosha.directtalk:id/landing_grid_item_text"));
	
	
	
	//appiumDriver.scrollTo(e);
	//WebDriverWait wait=new WebDriverWait(appiumDriver, 30);
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.akosha.directtalk:id/view_profile")));
	
	//TouchAction action = new TouchAction(appiumDriver);
		
//	Thread.sleep(5000);
//	 for(int x=3;x<6;x++)
//	    {
//			appiumDriver.swipe(0,239,489,792,5);
//		
//	    }

 /*List<MobileElement> c = appiumDriver.findElements(By.id("com.akosha.directtalk:id/landing_grid_item_icon"));
 System.out.println(c.size());
 
 for (int i = 0; i <c.size(); i++)
 {
	 if (i<10) {
		 c.get(i).click();
		 String nameString = appiumDriver.findElement(By.className("android.widget.ImageButton")).getText();
		 appiumDriver.findElement(By.className("android.widget.ImageButton")).click();	
		 //String nameString = c.get(i).getText();
		 System.out.println("click on the widgets : " + nameString );
	} else
	{
		appiumDriver.swipe(200, 900, 200, 300, 2000);
			c.get(i).click();
			 String nameString = appiumDriver.findElement(By.className("android.widget.ImageButton")).getText();
		 appiumDriver.findElement(By.className("android.widget.ImageButton")).click();	
      // String nameString = c.get(i).getText();
		 System.out.println("click on the widgets : " +nameString );
	}
	
}*/
	
//	appiumDriver.findElement(By.name("Check rates")).click();
//	List <WebElement> c = appiumDriver.findElements(By.className("android.widget.TextView"));
//	int d = c.size();
//	for (WebElement e:c)
//	{
//		String actual = e.getText();
//		//Assert.assertEquals(actual, );
//		System.out.println(actual);
//	}
//	
		
}
}
