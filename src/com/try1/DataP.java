package com.try1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataP 
{
	    @DataProvider(name = "data-provider")
	    public Object[][] dataProviderMethod() 
	    {
	    	return new Object[][] 	  
	        		{ 
	    			{ "data one" }, { "data two" },{"data three"} ,{"data four"}
	    			};
	        		 
	    }
	 
	    @Test(dataProvider = "data-provider")
	    public void testMethod(String data) 
	    {
	        System.out.println("Data is: " + data);
	    }
	}

