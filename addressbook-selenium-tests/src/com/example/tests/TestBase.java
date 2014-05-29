package com.example.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app = null; //link to ApplicationManager

	
	@BeforeTest
	public synchronized void setUp() throws Exception {
		if (app == null) {
			app = new ApplicationManager();
		}
	    
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	  }

}
