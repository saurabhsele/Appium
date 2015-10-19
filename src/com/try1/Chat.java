package com.try1;

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


public class Chat 
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
		
		AndroidDriver appiumDriver=new AndroidDriver(new URL("http://localhost:4723/wd/hub/"), DC);
		
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
	    
	    /*working with camers*/
	    
	   /* appiumDriver.findElement(By.id("com.akosha.directtalk:id/chat_options_or_enter_chat")).click();
	    appiumDriver.findElement(By.name("Camera")).click();
	    appiumDriver.findElement(By.id("com.lenovo.scgmtk:id/shutter_button_icon")).click();
	    appiumDriver.findElement(By.id("com.lenovo.scgmtk:id/btn_done")).click();*/
	    
	    appiumDriver.findElement(By.id("com.akosha.directtalk:id/chat_options_or_enter_chat")).click();
	    appiumDriver.findElement(By.name("Camera")).click();
	    
	/*    
	 * try upload img but problem is not getting intend
	 * 
	 * public void onActivityResult(int requestCode, int resultCode, Intent data) {
	        if (resultCode == RESULT_OK) {
	            if (requestCode == SELECT_PICTURE) {
	                Uri selectedImageUri = data.getData();
	                selectedImagePath = getPath(selectedImageUri);
	            }
	        }
	    }

	    *//**
	     * helper to retrieve the path of an image URI
	     *//*
	    public String getPath(Uri uri) {
	            // just some safety built in 
	            if( uri == null ) {
	                // TODO perform some logging or show user feedback
	                return null;
	            }
	            // try to retrieve the image from the media store first
	            // this will only work for images selected from gallery
	            String[] projection = { MediaStore.Images.Media.DATA };
	            Cursor cursor = managedQuery(uri, projection, null, null, null);
	            if( cursor != null ){
	                int column_index = cursor
	                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
	                cursor.moveToFirst();
	                return cursor.getString(column_index);
	            }
	            // this is our fallback here
	            return uri.getPath();
	    }*/
	    
	  //  appiumDriver.findElement(By.id("com.lenovo.scgmtk:id/shutter_button_icon")).click();
	    appiumDriver.findElement(By.id("com.android.camera2:id/shutter_button")).click();
	    appiumDriver.findElement(By.id("com.lenovo.scgmtk:id/btn_done")).click();
	    
	     
}
}
