package com.example.fw;

public class ContactHelper extends HelpersBase {

	public ContactHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}
	
	public void createContact(Contact contact) {
       initContactCreation();
       fillContactForm(contact);
       confirmContactCreation();
	}

	
	private void initContactCreation() {
		manager.getAutoItHelper()
		    	.winWaitAndActivate("AddressBook Portable", "", 5000)
		    	.click("Add").winWaitAndActivate("Add Contact", "", 5000);
	}
	
	private void fillContactForm(Contact contact) {
		manager.getAutoItHelper()
		    	.send("TDBEdit12", contact.firstName)
		    	.send("TDBEdit11", contact.lastName);
	}
	
	private void confirmContactCreation() {
		manager.getAutoItHelper()
		    	.click("Save")
		    	.winWaitAndActivate("AddressBook Portable", "", 5000);
	}

	public Contact getFirstContact() {
		manager.getAutoItHelper().focus("TListView1")
		.send("{DOWN}{SPACE}")
		.click("Edit")
		.winWaitAndActivate("Update Contact", "", 5000);
		Contact contact = new Contact()
			 .setFirstName(manager.getAutoItHelper().getText("TDBEdit12"))
		     .setLastName(manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper()
		   .click("Cancel")
		   .winWaitAndActivate("AddressBook Portable", "", 5000);
		return contact;
	}
	
	public void deleteFirstContact() throws InterruptedException {
		manager.getAutoItHelper()
    	.winWaitAndActivate("AddressBook Portable", "", 5000);
		manager.getAutoItHelper().focus("TListView1")
		.send("{DOWN}{SPACE}");
		Thread.sleep(1000);
		manager.getAutoItHelper().focus("TListView1")
		.click("TRbButton2");
		manager.getAutoItHelper()
		.winWaitAndActivate("Confirm", "", 5000)
		.click("TButton2").winWaitAndActivate("AddressBook Portable", "", 5000);
		}
	
	public void deleteAllContact() throws InterruptedException {
		manager.getAutoItHelper()
    	.winWaitAndActivate("AddressBook Portable", "", 5000);
		manager.getAutoItHelper().focus("TRbPanel3")
		.click("TRbButton6");
		Thread.sleep(1000);
		manager.getAutoItHelper()
		.click("TRbButton2")
		.winWaitAndActivate("Confirm", "", 5000)
		.click("TButton2").winWaitAndActivate("AddressBook Portable", "", 5000);
		}
}
