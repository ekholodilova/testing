package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper.FormButtons;

public class ContactRemoveTests extends TestBase {
	
	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		
		//save old state
		 List<ContactData> oldList = app.getContactHelper().getContacts();
		 
		app.getNavigationHelper().gotoHomePage();
		
		//actions
		app.getContactHelper().deleteContact(0,FormButtons.EDIT.getCode());
	    app.getContactHelper().returnToHomePage();
	    
	    //save new state
	 	List<ContactData> newList = app.getContactHelper().getContacts();
	   
	     //compare states
	     oldList.remove(0);
	     Collections.sort(oldList);
	     Collections.sort(newList);
	     assertEquals(newList, oldList);
	}

}
