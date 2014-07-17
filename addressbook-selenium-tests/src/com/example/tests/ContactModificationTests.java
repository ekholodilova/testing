package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


import java.util.Collections;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;


public class ContactModificationTests extends TestBase {

	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) {

		// save old state
		 SortedListOf<ContactData> oldList = app.getContactHelper().getUiContacts();
		Collections.sort(oldList);
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);
		
	
		//compare contact from edit page with the same from db
		SortedListOf<ContactData> newList = (SortedListOf<ContactData>) app.getHibernateHelper().listContacts();
		Collections.sort(newList);
		ContactData dbContact = newList.get(index);
		ContactData uiContact = app.getContactHelper().readContactByIndex(index+2);
		assertThat(uiContact, equalTo(dbContact));
		

		// actions
		app.getContactHelper().modifyContact(index,contact);
		
		// save new state
		  //SortedListOf<ContactData> newList = app.getContactHelper().getUiContacts();

		// compare states
		//compare ui - db 
		assertThat(app.getContactHelper().getUiContacts(), equalTo(app.getHibernateHelper().listContacts()));	
		
	}
}
