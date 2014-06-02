package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	    }
		
	public void initContactCreation() {
		    click(By.name("add new"));
		  }

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"),contact.firstname);
		type(By.name("lastname"),contact.lastname);
		type(By.name("address"),contact.address);
		type(By.name("home"),contact.home);
		type(By.name("mobile"),contact.mobile);
		type(By.name("work"),contact.work);
		type(By.name("email"),contact.email);
		type(By.name("email2"),contact.email2);
		selectByText(By.name("bday"), contact.bday);
		selectByText(By.name("bmonth"), contact.bmonth);
		type(By.name("byear"),contact.byear);
		selectByText(By.name("new_group"), contact.newgroup); //new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contact.newgroup);
		type(By.name("address2"),contact.address2);
		type(By.name("phone2"),contact.phone2);
	  }

	
public void submitContactCreation() {
		click(By.name("submit"));
	      }

public void modifyContactCreation() {
	click(By.name("modifiy"));
      }

public void deleteContact(int indexRow,int indexTable) {
	selectContactByIndex(indexRow);
	IdentifierContactByIndexes(indexRow, indexTable);
	selectButtonByValue("Delete");
	
	}

public void selectContactByIndex(int indexRow) {
	click(By.xpath("//tr[" +(indexRow+1) + "]" +  "/td/input[@name='selected[]']"));
	}

/*
 The indexTable parameter may have the following value:
   indexTable=6  if user click on "Details"
   indexTable=7  if user click on "Edit"
   indexTable=8  if user click on "vCard"
   indexTable=9  if user click on "Google Maps"
   indexTable=10 if user click on "Guessed homepage (www.mail.ru)"
 */
public void IdentifierContactByIndexes(int indexRow, int indexTable) {
	click(By.xpath("//tr[" +(indexRow+1) + "]" +  "/td[" + indexTable+ "]/a/img"));
	}

public void selectButtonByValue(String buttonName) {
	click(By.xpath("//input[@value='" + buttonName + "']"));
	}

public void initContactModification(int indexRow, int indexTable) {
	selectContactByIndex(indexRow);
	IdentifierContactByIndexes(indexRow,indexTable);
	}

}

