package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.utils.RandomGenerateUtils;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
     if (args.length <3) {
    	 System.out.println("Please specify parameters : <amount of test data> <file> <format>");
    	 return;
     }
     
     int amount = Integer.parseInt(args[0]);
     File file = new File(args[1]);
     String format = args[2];

     if (file.exists()) {
    	System.out.println("File exists, please remote it manually: " + file) ;
    	return;
     }
 	List<ContactData> contacts = generateRandomContacts(amount);
	if("csv".equals(format)) {
		saveContactsToCsvFile(contacts, file);
	} else if  ("xml".equals(format)) {
		saveContactsToXmlvFile(contacts, file);		
	} else {
	  System.out.println("Unkhown format" + format);
	  return;
	}
}

	private static void saveContactsToXmlvFile(List<ContactData> contacts, File file) {
		// TODO Auto-generated method stub
		
	}

	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
     FileWriter writer = new FileWriter(file);
	 for (ContactData contact : contacts) {
		 writer.write(contact.getFirstname() + ";" + contact.getLastname() + ";" + contact.getAddress() + ";" +
				 	  contact.getHome() + ";" + contact.getMobile() + ";" + contact.getWork() + ";" +
				 	  contact.getEmail1() + ";" + contact.getEmail2() + ";" + contact.getBday() + ";" +
				 	  contact.getBmonth() + ";" + contact.getByear() + ";" + contact.getAddress2() + ";" +
				 	  contact.getPhone2() + ";!" +"\n");
	 }
     writer.close();
	}

	
	public static List<ContactData> loadContactsFromCsvFile (File file) throws IOException {
		List<ContactData> list = new ArrayList<ContactData>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(";");
			ContactData contact = new ContactData()
			      .withFirstName(part[0])
			      .withLastName(part[1])
			      .withAddress(part[2])
			      .withHome(part[3])
			      .withMobile(part[4])
			      .withWork(part[5])
			      .withEmailDomain1(part[6])
			      .withEmailDomain2(part[7])
			      .withBday(part[8])
			      .withBmonth(part[9])
			      .withByear(part[10])
			      .withAddress2(part[11])
			      .withPhone2(part[12]);			      
			list.add(contact);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return list;
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();

		for (int i = 0; i < amount; i++) {
			Random rnd = new Random();
			ContactData contact = new ContactData()
				.withFirstName(RandomGenerateUtils.generateRandomFirstNameString())
				.withLastName(RandomGenerateUtils.generateRandomLastnameString())
				.withAddress(RandomGenerateUtils.generateRandomAdress() + ", " + rnd.nextInt(100))
				.withHome(RandomGenerateUtils.generateRandomSetNumber(7))
				.withMobile(RandomGenerateUtils.generateRandomPhoneMobileNumber())
				.withWork(RandomGenerateUtils.generateRandomSetNumber(7))
				.withEmailDomain1(RandomGenerateUtils.generateRandomEmailDomain())
				.withEmail(null) // if null - generate new using random domain
				.withEmailDomain2(RandomGenerateUtils.generateRandomEmailDomain())
				.withEmail2(null)
				.withBday(String.valueOf(rnd.nextInt(29)))
				.withBmonth(RandomGenerateUtils.generateRandomMonthString())
				.withByear(RandomGenerateUtils.generateRandomYear())
				.withAddress2(RandomGenerateUtils.generateRandomString() + ", " + rnd.nextInt(100))
				.withPhone2(RandomGenerateUtils.generateRandomSetNumber(7));
			list.add(contact );
		}
		return list;
	}
	
		
}