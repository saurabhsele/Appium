package com.try1;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class Adb 
{
public static void main(String[] args) throws IOException 
{
//Runtime.getRuntime().exec("adb devices");	
	ProcessBuilder p=new ProcessBuilder("/Users/saurabhrai/Library/Android/sdk/platform-tools/adb","devices");
	Process ps=p.start();
	String a = IOUtils.toString(ps.getInputStream());
	System.out.println(a);
}
}
