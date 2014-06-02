package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().gotoHomePage();
		app.getContactHelper().initContactModification(1,7);
		ContactData contact = new ContactData();
	    contact.firstname = "Test"; 
	    contact.lastname = "Test"; 
	    contact.email = "test@mail.ru"; 
	    contact.email2 = "test@gmail.com"; 
	    contact.bday = "1"; 
	    contact.bmonth = "June"; 
	    contact.byear = "2000";
	    app.getContactHelper().fillContactForm( contact);
		app.getContactHelper().selectButtonByValue("Update");
	    app.getContactHelper().returnToHomePage();
	    
	    
	    //Modify via Details
	    app.getContactHelper().initContactModification(2,6);
	    app.getContactHelper().modifyContactCreation();
		ContactData contact1 = new ContactData();
	    contact1.firstname = "Test1"; 
	    contact1.lastname = "Test1"; 
	    contact1.email = "test1@mail.ru"; 
	    contact1.email2 = "test1@gmail.com"; 
	    contact1.bday = "6"; 
	    contact1.bmonth = "June"; 
	    contact1.byear = "2000";
	    app.getContactHelper().fillContactForm( contact1);
		app.getContactHelper().selectButtonByValue("Update");
	    app.getContactHelper().returnToHomePage();
	    
	}
}
 