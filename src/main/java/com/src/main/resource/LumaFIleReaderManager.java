package com.src.main.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.Assert;

public class LumaFIleReaderManager {
	private static  FileInputStream fileInPutStrem;
	private static Properties property;
	private static void setUpProperty()  {
	if(property==null) {
		File file =new File("C:\\Users\\surya\\Desktop\\Luma\\src\\main\\java\\com\\src\\main\\resource\\luma.properties");
	try {
		fileInPutStrem = new FileInputStream(file);
		property=new Properties();
		property.load(fileInPutStrem);
	} catch (FileNotFoundException e) {
		Assert.fail("FILENOTFOUND EXPCEPTION OCCUR DURING THE PROPERTY LOAD");	
	} catch (Throwable e) {
		Assert.fail("FILENOTFOUND EXPCEPTION OCCUR DURING THE PROPERTY LOAD");	
		
	}
	}
	}     public static String getDataProperty (String datavalue)  {
		 setUpProperty();
	  String browsername = property.getProperty(datavalue);
	return browsername;
	 
	  
	}

}
