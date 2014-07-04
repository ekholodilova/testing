package com.example.tests;

import java.util.ArrayList;
import java.util.List;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;

public class TestBase {

	protected static ApplicationManager app = null; // link to
													// ApplicationManager
	
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

	public static  List<Object[]> wrapGroupForDataProvider(List<GroupData> groups) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (GroupData group : groups) {
        	list.add(new Object[]{group});
        }
		return list;
	}
	
	public static  List<Object[]> wrapContactForDataProvider(List<ContactData> contacts) {
        List<Object[]> list = new ArrayList<Object[]>();
        for (ContactData contact : contacts) {
        	list.add(new Object[]{contact});
        }
		return list;
	}
}
