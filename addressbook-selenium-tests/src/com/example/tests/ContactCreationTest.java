package com.example.tests;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	 app.getNavigationHelper().openMainPage();
	 app.getNavigationHelper().gotoContactPage();
	//fill contact form
    ContactData contact = new ContactData();    //local variable
    contact.firstname = "John"; //filling data by manually
    contact.lastname = "Smeet"; 
    contact.address = "Rose street,1-20"; 
    contact.home = "(812) 5554477"; 
    contact.mobile = "+79218889911";   
    contact.work = "812) 5555412";   
    contact.email = "J@mail.ru"; 
    contact.email2 = "J@gmail.com"; 
    contact.bday = "1"; 
    contact.bmonth = "June"; 
    contact.byear = "1970";
    contact.newgroup = "[none]"; 
    contact.address2 = "Rose street,1-25"; 
    contact.phone2 = "(812) 5764499";
    app.getContactHelper().fillContactForm( contact);
    //Save data
    app.getContactHelper().submitContactCreation();
    //go to Home page
    app.getContactHelper().returnToHomePage();
  }

  @Test
  public void testEmptyContactCreation() throws Exception {
	 app.getNavigationHelper().openMainPage();
	 app.getNavigationHelper().gotoContactPage();
	//fill contact form
    ContactData contact = new ContactData();    //local variable
    contact.firstname = ""; //filling data by manually
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
    //Save data
    app.getContactHelper().submitContactCreation();
    //go to Home page
    app.getContactHelper().returnToHomePage();
  }

 }