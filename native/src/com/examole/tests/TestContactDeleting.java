package com.examole.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.fw.Contact;


public class TestContactDeleting extends TestBase {
	
	@Test
	
	public void DeleteFirstContact() throws InterruptedException {
		Contact contact = new Contact().setFirstName("tester").setLastName("tester");
		app.getContactHelper().deleteFirstContact();
		Contact deletedContact = app.getContactHelper().getFirstContact();
		Assert.assertNotEquals(contact, deletedContact);
	}
	
	@Test
	
	public void DeleteAllContact() throws InterruptedException {
		app.getContactHelper().deleteAllContact();
	}

}
