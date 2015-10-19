package com.try1;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.net.URL;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Excel 
{
	public static AndroidDriver appiumDriver;
	public static HashMap<String, HashMap<String, String>> readCSVFile(String dataFilePath) throws IOException 
	{
		HashMap<String, HashMap<String, String>> dataMap = new HashMap<String, HashMap<String, String>>();

		String line = "";
		String csvDelimiter = "\t";
		BufferedReader brCSVDataReader = new BufferedReader(new FileReader(
				dataFilePath));
		int rowIndex = 0;
		ArrayList<String> colHeaders = new ArrayList<String>();
		
		while ((line = brCSVDataReader.readLine()) != null) {

			//System.out.println("Row Num: "+rowIndex);
			
			String rowKey = line.split(csvDelimiter)[0];
			

			int numOfCols = line.split(csvDelimiter).length;
			//System.out.println("Cols " + numOfCols);

			if (rowIndex == 0) {
				
				for(int j = 0; j < numOfCols; j++)
				{
					colHeaders.add(line.split(csvDelimiter)[j]);
					//rowMap.put(colHeaders.get(j), line.split(csvDelimiter)[j]);
				}
				
			} else {
				
				HashMap<String, String> rowMap = new HashMap<String, String>();
				
				for (int j = 0; j < numOfCols; j++) {
					
					rowMap.put(colHeaders.get(j), line.split(csvDelimiter)[j]);
				}
				
				dataMap.put(rowKey, rowMap);
			}
			//System.out.println("Row: "+rowIndex+" Data: "+rowMap)
			
			rowIndex++;
		}

		//System.out.println(dataMap);
		return dataMap;
	}	

	String excelpath="/Users/saurabhrai/Documents/Addaddressdata.xlsx";
  	public String getExcelData(String SheetName,int RowNum,int cellNum) throws EncryptedDocumentException, InvalidFormatException, IOException{
  		FileInputStream f1s=new FileInputStream(new File(excelpath));
  		Workbook wb=WorkbookFactory.create(f1s);
  		Sheet sh=wb.getSheet(SheetName);
  		Row row=sh.getRow(RowNum);
  		String data=row.getCell(cellNum).getStringCellValue();
  		return data;
  		
  	}
	public int RowCount(String SheetName) throws IOException,InvalidFormatException{
  		FileInputStream f1s=new FileInputStream(excelpath);
  		Workbook wb=WorkbookFactory.create(f1s);
  		Sheet sh=wb.getSheet(SheetName);
  	    int rowCount=sh.getLastRowNum();
		return rowCount;
  	}
	public int RowCoulm(String SheetName,int rownum) throws IOException,InvalidFormatException{
  		FileInputStream f1s=new FileInputStream(excelpath);
  		Workbook wb=WorkbookFactory.create(f1s);
  		
  		Sheet sh=wb.getSheet(SheetName);
  		Row row=sh.getRow(rownum);
  		int cell=row.getLastCellNum();
  	    
		return cell;
  	}
	public static void pressBackButtonOfDevice() {
		appiumDriver.sendKeyEvent(4);

	}
  	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException, Exception 
  	{
  		Excel ex = new Excel();
	DesiredCapabilities DC = new DesiredCapabilities();
	DC.setCapability(MobileCapabilityType.DEVICE_NAME, "android");
	DC.setCapability(MobileCapabilityType.AUTOMATION_NAME, "appium");
	DC.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
	//DC.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.3");
	DC.setCapability(MobileCapabilityType.BROWSER_NAME, "android");
	DC.setCapability(MobileCapabilityType.HAS_TOUCHSCREEN,true);
	DC.setCapability(MobileCapabilityType.APP, "/Users/saurabhrai/Desktop/akosha-staging-universal-debug.apk");
	
	 appiumDriver=new AndroidDriver(new URL("http://localhost:4723/wd/hub/"), DC);
	
	System.out.println("done");
	Thread.sleep(3000);
	MobileElement a = (MobileElement) appiumDriver.findElement(By.id("com.akosha.directtalk:id/ed_phone_number"));
	int b = a.getText().length();
	for (int i = 0; i < b; i++) {appiumDriver.sendKeyEvent(67); /* "KEYCODE_DEL" */}
	a.sendKeys("9739559642");
	appiumDriver.findElement(By.name("Next")).click();
	appiumDriver.findElement(By.name("CONFIRM")).click();
	appiumDriver.findElement(By.id("com.akosha.directtalk:id/ed_otp")).sendKeys("1234");
	appiumDriver.findElement(By.name("Done")).click();
	WebDriverWait wait=new WebDriverWait(appiumDriver, 30);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.akosha.directtalk:id/view_profile")));
    appiumDriver.findElement(By.id("com.akosha.directtalk:id/view_profile")).click();
    appiumDriver.findElement(By.name("Saved addresses")).click();
   
    String[] ids = {"et_first_name","et_last_name","et_address","et_state","et_locality","et_city","et_pin_code","et_tag"};
    
    for (int i = 1; i < 2; i++) 
    {
    	appiumDriver.findElement(By.id("com.akosha.directtalk:id/submit_button_add_address")).click();
    	for (int j = 0; j < ex.RowCoulm("Sheet1", i); j++) {
    		if(j >= 4)
    			ex.pressBackButtonOfDevice();
    		appiumDriver.findElement(By.id("com.akosha.directtalk:id/"+ids[j])).clear();
    		appiumDriver.findElement(By.id("com.akosha.directtalk:id/"+ids[j])).sendKeys(ex.getExcelData("Sheet1", i, j));
    		
    	}
    	Thread.sleep(2000);
    	appiumDriver.hideKeyboard();
    	appiumDriver.findElement(By.id("com.akosha.directtalk:id/btn_save_address")).click();
    }
  	}
}
/*appiumDriver.findElement(By.id("com.akosha.directtalk:id/et_first_name")).sendKeys(ex.getExcelData("Sheet1", i, 0));
appiumDriver.findElement(By.id("com.akosha.directtalk:id/et_last_name")).sendKeys(ex.getExcelData("Sheet1", i, 1));
appiumDriver.findElement(By.id("com.akosha.directtalk:id/et_address")).sendKeys(ex.getExcelData("Sheet1", i, 2));
appiumDriver.findElement(By.id("com.akosha.directtalk:id/et_state")).sendKeys(ex.getExcelData("Sheet1", i, 3));
appiumDriver.findElement(By.id("com.akosha.directtalk:id/et_locality")).sendKeys(ex.getExcelData("Sheet1", i, 4));
appiumDriver.findElement(By.id("com.akosha.directtalk:id/et_city")).sendKeys(ex.getExcelData("Sheet1", i, 5));*/

		/*appiumDriver.findElement(By.id("com.akosha.directtalk:id/et_pin_code")).sendKeys(ex.getExcelData("Sheet1", i, 6));
appiumDriver.findElement(By.id("com.akosha.directtalk:id/et_tag")).sendKeys(ex.getExcelData("Sheet1", i, 7));*/
		/*ex.pressBackButtonOfDevice();*/
		/*appiumDriver.findElement(By.id("com.akosha.directtalk:id/btn_save_address")).click();*/ //com.akosha.directtalk:id/btn_save_address
