package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Collections;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper.FormButtons;
import com.example.utils.SortedListOf;

public class ContactRemoveTests extends TestBase {

	@Test
	public void deleteSomeContact() {

		// save old state
		SortedListOf<ContactData> oldList = app.getContactHelper().getUiContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);

		// actions
		app.getContactHelper().deleteContact(index, FormButtons.EDIT.getCode());

		// save new state
		    //SortedListOf<ContactData> newList = app.getContactHelper().getUiContacts();
		

		// compare states
		//compare ui - db
		assertThat(app.getContactHelper().getUiContacts(), equalTo(app.getHibernateHelper().listContacts()));
	}

}
