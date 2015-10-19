package com.try1;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testn 
{
	@BeforeTest
	public void befor()
	{
		System.out.println("before");
	}
@Test
public void testb()
{
	System.out.println("hello b");
}
@Test
public void testa()
{
	System.out.println("hello a");
}
@Test
public void testc()
{
	System.out.println("hello c");
}
@AfterTest
public void after()
{
	System.out.println("after");
}
}
