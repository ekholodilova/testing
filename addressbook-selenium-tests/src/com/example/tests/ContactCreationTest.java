package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	 app.getNavigationHelper().openMainPage();
	//save old state
	 List<ContactData> oldList = app.getContactHelper().getContacts();
	 app.getNavigationHelper().gotoContactPage();
	 
    //actions
    ContactData contact = new ContactData();    //local variable
    contact.firstname = "yyyzznnmm"; 
    contact.lastname = "zzz";
    contact.address = "Rose street,1-20"; 
    contact.home = "(812) 9964499"; 
    contact.mobile = "+79218889911";   
    contact.work = "(812) 9999499";   
    contact.email = "aaa@mail.ru"; 
    contact.email2 = "aaa@gmail.com"; 
    contact.bday = "1"; 
    contact.bmonth = "June"; 
    contact.byear = "1970";
    contact.newgroup = "[none]"; 
    contact.address2 = "Rose street,1-25"; 
    contact.phone2 = "(812) 5764499";
    app.getContactHelper().fillContactForm( contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  
    //save new state
	List<ContactData> newList = app.getContactHelper().getContacts();
  
    //compare states
    oldList.add(contact);
    Collections.sort(oldList);
    Collections.sort(newList);
    assertEquals(newList, oldList);
  }

  @Test
  public void testEmptyContactCreation() throws Exception {
	 app.getNavigationHelper().openMainPage();
	 
	//save old state
		 List<ContactData> oldList = app.getContactHelper().getContacts();
		 
	 app.getNavigationHelper().gotoContactPage();
	 
	//actions
    ContactData contact = new ContactData();   
    contact.firstname = ""; 
    contact.lastname = ""; 
    contact.address = ""; 
    contact.home = ""; 
    contact.mobile = "";   
    contact.work = "";   
    contact.email = ""; 
    contact.email2 = ""; 
    contact.bday = "-"; 
    contact.bmonth = "-"; 
    contact.byear = "";
    contact.newgroup = "[none]"; 
    contact.address2 = ""; 
    contact.phone2 = "";
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    
    //save new state
 	List<ContactData> newList = app.getContactHelper().getContacts();
   
     //compare states
     oldList.add(contact);
     Collections.sort(oldList);
     Collections.sort(newList);
     assertEquals(newList, oldList);
  }

 }