package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemoveTests extends TestBase {
	
	@Test
	public void deleteSomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoHomePage();
		app.getContactHelper().deleteContact(1,7);
	    app.getContactHelper().returnToHomePage();
	}

}
