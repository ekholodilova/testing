package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper.FormButtons;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		
		//save old state
		 List<ContactData> oldList = app.getContactHelper().getContacts();
		
		app.getNavigationHelper().gotoHomePage();
		
	    //actions
		app.getContactHelper().initContactModification(0, FormButtons.EDIT.getCode());
		ContactData contact = new ContactData();
	    contact.firstname = "fgh"; 
	    contact.lastname = "fgh";
	    contact.home = "(925)1111111"; 
	    contact.email = "fgh@mail.ru"; 
	    contact.email2 = "fgh@gmail.com"; 
	    contact.bday = "1"; 
	    contact.bmonth = "July"; 
	    contact.byear = "1982";
	    app.getContactHelper().fillContactForm( contact);
		app.getContactHelper().selectButtonByValue("Update");
	    app.getContactHelper().returnToHomePage();
		   
	    //save new state
		List<ContactData> newList = app.getContactHelper().getContacts();
	  
	    //compare states
	    oldList.remove(0);
	    oldList.add(contact);
	    Collections.sort(oldList);
	    Collections.sort(newList);
	    assertEquals(newList, oldList);
	  }
}
 