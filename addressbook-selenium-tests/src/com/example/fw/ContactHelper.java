package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.tests.GroupData;

public class ContactHelper extends HelperBase {
	
	public enum FormButtons {
		DETAILS(6), EDIT(7), VCARD(8), GOOGLEMAPS(9);
		
		private int code;
		
		private FormButtons(int c){
			code = c;
		}
		public int getCode(){
			return code;
		}
	}

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
	identifierContactByIndexes(indexRow, indexTable);
	selectButtonByValue("Delete");
	
	}

	public void selectContactByIndex(int indexRow) {
	click(By.xpath("//tr[" +(indexRow+2) + "]" +  "/td/input[@name='selected[]']"));
	}

	public void identifierContactByIndexes(int indexRow, int indexTable) {
	click(By.xpath("//tr[" +(indexRow+2) + "]" +  "/td[" + indexTable+ "]/a/img"));
	}

	public void selectButtonByValue(String buttonName) {
	click(By.xpath("//input[@value='" + buttonName + "']"));
	}

	public void initContactModification(int indexRow, int indexTable) {
	selectContactByIndex(indexRow);
	identifierContactByIndexes(indexRow,indexTable);
	}
	
	public List<ContactData> getContacts() {
	    List<ContactData> contacts = new ArrayList<ContactData>();
	    List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
	    int i = 2;
	    for (WebElement checkbox : checkboxes) {
	    	ContactData contact = new ContactData();
	    	String title = checkbox.getAttribute("title");
	    	String fullname = title.substring("Select (".length(),  title.length() - ")".length());
	    	
	    	//initial values
	    	contact.firstname = "";
	    	contact.lastname = "";
	    	contact.email = "";
	    	contact.home = "";
	    	
	    	String[] names = null;
	    	if(fullname != null) {
	    		names = fullname.split(" ");
	    	} 
	    	if(names.length > 0) {
	    		contact.firstname = names[0];
	    	}
	    	if(names.length > 1) {
	    		contact.lastname = names[1];
	    	}
	    	
	    	String email = checkbox.getAttribute("accept");
	    	if (email.indexOf(";") != -1) {
	    		contact.email = email.substring(0,email.indexOf(";"));
	    	}
	    	//System.out.println("GETTING CONTACNTS: " + contact.firstname +" "+contact.lastname+" "+contact.email);
	    	WebElement column =  driver.findElement(By.xpath("//tr[" + i +"]/td[" + 5 +"]"));
	    	if (column != null) {
		    	contact.home = column.getText();
		    	
		    //There is bug in home page: delete spaces. Therefore we delete all spaces for compare
	
		    contact.home = contact.home.trim();
		    	
		    if (contact.home.indexOf(ContactData.SPACE) != -1) {
		    	contact.home.replace(ContactData.SPACE, ContactData.NO_SPACE);
		    	}

	    	}
	    	
	    	i++;
	    	
	    	contacts.add(contact);
	    }
	    
			return contacts;
			
		}

}

