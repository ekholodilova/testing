package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	private static final int HOME_COLUMN = 5;
	private static final int EMAIL_COLUMN = 4;
	private static final int LAST_NAME_COLUMN = 3;
	private static final int FIRST_NAME_COLUMN = 2;

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
		type(By.name("firstname"), contact.firstname);
		type(By.name("lastname"), contact.lastname);
		type(By.name("address"), contact.address);
		type(By.name("home"), contact.home);
		type(By.name("mobile"), contact.mobile);
		type(By.name("work"), contact.work);
		type(By.name("email"), contact.email);
		type(By.name("email2"), contact.email2);
		selectByText(By.name("bday"), contact.bday);
		selectByText(By.name("bmonth"), contact.bmonth);
		type(By.name("byear"), contact.byear);
		selectByText(By.name("new_group"), contact.newgroup);
		type(By.name("address2"), contact.address2);
		type(By.name("phone2"), contact.phone2);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void modifyContactCreation() {
		click(By.name("modifiy"));
	}

	public void deleteContact(int indexRow, int indexTable) {
		selectContactByIndex(indexRow);
		identifierContactByIndexes(indexRow, indexTable);
		selectButtonByValue("Delete");

	}

	public void selectContactByIndex(int indexRow) {
		click(By.xpath("//tr[" + (indexRow + 2) + "]"
				+ "/td/input[@name='selected[]']"));
	}

	public void identifierContactByIndexes(int indexRow, int indexTable) {
		click(By.xpath("//tr[" + (indexRow + 2) + "]" + "/td[" + indexTable
				+ "]/a/img"));
	}

	public void selectButtonByValue(String buttonName) {
		click(By.xpath("//input[@value='" + buttonName + "']"));
	}

	public void initContactModification(int indexRow, int indexTable) {
		selectContactByIndex(indexRow);
		identifierContactByIndexes(indexRow, indexTable);
	}

	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		int i = 2;
		int total = findElements(By.name("selected[]")).size();
		while (i < (total + 2)) {
			ContactData contact = new ContactData();
			// TODO change lastname and firstname initialization when issue #XXX
			// would be fixed
			contact.lastname = getContactAttributeValue(i, FIRST_NAME_COLUMN);
			contact.firstname = getContactAttributeValue(i, LAST_NAME_COLUMN);
			contact.email = getContactAttributeValue(i, EMAIL_COLUMN);
			contact.home = getContactAttributeValue(i, HOME_COLUMN);
			//remove spaces
			contact.home = contact.home.trim();
			if (contact.home.indexOf(ContactData.SPACE) != -1) {
				contact.home.replace(ContactData.SPACE, ContactData.NO_SPACE);
			}
			contacts.add(contact);
			i++;
		}
		return contacts;
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
