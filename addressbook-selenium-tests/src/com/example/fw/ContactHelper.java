package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

public class ContactHelper extends WebDriverHelperBase {

	private static final int HOME_COLUMN = 5;
	private static final int EMAIL_COLUMN = 4;
	private static final int LAST_NAME_COLUMN = 3;
	private static final int FIRST_NAME_COLUMN = 2;
	public static boolean CREATION = true;
	public static boolean MODIFICATION = true;
	
	//private SortedListOf<ContactData> cachedContacts;


	public enum FormButtons {
		DETAILS(6), EDIT(7), VCARD(8), GOOGLEMAPS(9);

		private int code;

		private FormButtons(int c) {
			code = c;
		}

		public int getCode() {
			return code;
		}
	}
	
	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().contactAddNewPage();
		fillContactForm(contact,CREATION);
		submitContactCreation();
		returnToHomePage();
		//update model
		manager.getModel().addContact(contact);		
		return this;		
	}
	
	public ContactHelper deleteContact(int index, int indexTable) {
		selectContactByIndex(index);
		identifierContactByIndexes(index, indexTable);
		selectButtonByValue("Delete");
		returnToHomePage();
		manager.getModel().removeContact(index);		
		return this;

	}
	
	public ContactHelper modifyContact(int index,ContactData  contact) {
		manager.navigateTo().mainPage();
		initContactModification(index, FormButtons.EDIT.getCode());
		fillContactForm(contact,MODIFICATION);
		selectButtonByValue("Update");
		returnToHomePage();
		manager.getModel().removeContact(index).addContact(contact);
		return this;
	}

	//================================================================================
	
	public SortedListOf<ContactData> getUiContacts() {
		SortedListOf<ContactData> contacts = new SortedListOf<ContactData>();
		manager.navigateTo().mainPage();
		int i = 2;
		int total = findElements(By.name("selected[]")).size();
		while (i < (total + 2)) {
			// TODO change lastname and firstname initialization when issue #XXX would be fixed
			ContactData contact = new ContactData().withFirstName(getContactAttributeValue(i, LAST_NAME_COLUMN))
					.withLastName(getContactAttributeValue(i, FIRST_NAME_COLUMN))
					.withEmail1(getContactAttributeValue(i, EMAIL_COLUMN))
					.withHome(getContactAttributeValue(i, HOME_COLUMN));

			//remove spaces
			contact.trimHome();
			contacts.add(contact);
			i++;
		}
		return contacts;
	}
	
	public ContactData readContactByIndex(int index) {
		//returnToHomePage();
		manager.navigateTo().mainPage(); //selectContactByIndex(index);
		ContactData contact = new ContactData().withFirstName(getContactAttributeValue(index, LAST_NAME_COLUMN))
				.withLastName(getContactAttributeValue(index, FIRST_NAME_COLUMN))
				.withEmail1(getContactAttributeValue(index, EMAIL_COLUMN))
				.withHome(getContactAttributeValue(index, HOME_COLUMN));	

		/*WebElement firstName = driver.findElement(By.xpath("//input[2]"));
		contact.setFirstname(firstName.getAttribute("value"));

		WebElement lastName = driver.findElement(By.xpath("//input[3]"));
		contact.setLastname(lastName.getAttribute("value"));*/

		return contact;
	}

		
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
	}

	public ContactHelper initContactCreation() {
		click(By.name("add new"));
		return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType ) {
		type(By.name("firstname"), contact.getFirstname());
		type(By.name("lastname"), contact.getLastname());
		type(By.name("address"), contact.getAddress());
		type(By.name("home"), contact.getHome());
		type(By.name("mobile"), contact.getMobile());
		type(By.name("work"), contact.getWork());
		type(By.name("email"), contact.getEmail1());
		type(By.name("email2"), contact.getEmail2());
		selectByText(By.name("bday"), contact.getBday());
		selectByText(By.name("bmonth"), contact.getBmonth());
		type(By.name("byear"), contact.getByear());
		if (formType == CREATION) {
			selectByText(By.name("new_group"), contact.newgroup);
		} else {
			if (findElements(By.name("new group")).size() != 0) {
				throw new Error ("Group Selector exists in contact modification form");
			}
		}
			
		//selectByText(By.name("new_group"), contact.newgroup);
		type(By.name("address2"), contact.getAddress2());
		type(By.name("phone2"), contact.getPhone2());
		return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		return this;
	}

	public ContactHelper modifyContactCreation() {
		click(By.name("modifiy"));
		return this;
	}

	
	public ContactHelper selectContactByIndex(int indexRow) {
		click(By.xpath("//tr[" + (indexRow + 2) + "]"
				+ "/td/input[@name='selected[]']"));
		return this;
	}

	public ContactHelper identifierContactByIndexes(int indexRow, int indexTable) {
		click(By.xpath("//tr[" + (indexRow + 2) + "]" + "/td[" + indexTable
				+ "]/a/img"));
		return this;
	}

	public ContactHelper selectButtonByValue(String buttonName) {
		click(By.xpath("//input[@value='" + buttonName + "']"));
		return this;
	}

	public ContactHelper initContactModification(int indexRow, int indexTable) {
		selectContactByIndex(indexRow);
		identifierContactByIndexes(indexRow, indexTable);
		return this;
	}

	
	private String getContactAttributeValue(int row, int column) {
		WebElement element = findElement(By.xpath("//tr[" + row + "]/td["
				+ column + "]"));
		if (element != null) {
			return element.getText();
		}
		return "";
	}

}
