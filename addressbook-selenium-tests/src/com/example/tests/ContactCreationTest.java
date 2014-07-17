package com.example.tests;

import static org.junit.Assert.assertThat;
//import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactDataGenerator.loadContactsFromXmlFile;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ContactCreationTest extends TestBase {
		
		@DataProvider
		public Iterator<Object[]> contactsFromFile() throws IOException {
			return wrapContactForDataProvider(loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
		}
		
		@Test(dataProvider = "contactsFromFile")
		public void testContactCreationWithValidData(ContactData contact)
				throws Exception {

		// save old state
		       //SortedListOf<ContactData> oldList =	app.getModel().getContacts();  

		// actions
        app.getContactHelper().createContact(contact);
        
		// save new state
           //SortedListOf<ContactData> newList = app.getContactHelper().getUiContacts();

		// compare states
		//assertThat(newList,equalTo(oldList.withAdded(contact)));
        
        // compare model to implementation
        if (wantToCheck()) {
    		if ("yes".equals(app.getProperty("check.db"))) {
    			assertThat(app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));	
    			}
    		if ("yes".equals(app.getProperty("check.ui"))) {
    		assertThat(app.getModel().getGroups(), equalTo(app.getGroupHelper().getUiGroups()));
    			}
    		}
        
        //compare ui-db
        if ("yes".equals(app.getProperty("check.ui.db"))) {
        assertThat(app.getContactHelper().getUiContacts(), equalTo(app.getHibernateHelper().listContacts()));
           }
        
	}
}