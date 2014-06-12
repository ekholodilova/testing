package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {

	protected static ApplicationManager app = null; // link to
													// ApplicationManager

	private static String[] names = new String[] { "John", "Ann", "Kieth",
			"Jens", "Aric", "Boas", "David", "Martin", "Linda", "Leon" };
	private static String[] lastnames = new String[] { "Smith", "Abstract",
			"Bull", "Fat", "Thin", "Uils", "Braun", "Lind", "Lame", "Telemann" };
	private static String[] months = new String[] { "January", "February",
			"March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };
	private static String[] adress = new String[] { "Rose", "Direct", "Dance",
			"Coco", "Big", "Little", "Flower", "Shot", "Center", "Student",
			"Varna", "Fish" };

	@BeforeTest
	public synchronized void setUp() throws Exception {
		if (app == null) {
			app = new ApplicationManager();
		}

	}

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	}

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 5; i++) {
			GroupData group = new GroupData();
			group.name = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();
			list.add(new Object[] { group });
		}
		return list.iterator();

	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();

		for (int i = 0; i < 5; i++) {
			Random rnd = new Random();
			ContactData contact = new ContactData();
			contact.firstname = generateRandomFirstNameString();
			contact.lastname = generateRandomLastnameString();
			contact.address = generateRandomAdress() + ", " + rnd.nextInt(100);
			contact.home = generateRandomSetNumber(7);
			contact.mobile = generateRandomPhoneMobileNumber();
			contact.work = generateRandomSetNumber(7);
			contact.email = contact.firstname + "." + contact.lastname + ""
					+ generateRandomEmailDomain();
			contact.email2 = contact.firstname + "." + contact.lastname + ""
					+ generateRandomEmailDomain();
			contact.bday = String.valueOf(rnd.nextInt(29));
			contact.bmonth = generateRandomMonthString();
			contact.phone2 = generateRandomSetNumber(7);
			contact.byear = generateRandomYear();
			contact.address2 = generateRandomString() + ", " + rnd.nextInt(100);
			// contact.newgroup = "[none]";
			contact.address2 = generateRandomAdress() + ", " + rnd.nextInt(100);
			;
			contact.phone2 = generateRandomSetNumber(7);
			list.add(new Object[] { contact });
		}
		return list.iterator();
	}

	public String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}

	public String generateRandomFirstNameString() {
		Random random = new Random();
		return names[random.nextInt(names.length - 1)];
	}

	public String generateRandomLastnameString() {
		Random random = new Random();
		return lastnames[random.nextInt(lastnames.length - 1)];
	}

	public String generateRandomMonthString() {
		Random random = new Random();
		return months[random.nextInt(months.length - 1)];
	}

	public String generateRandomAdress() {
		Random random = new Random();
		String adressname = adress[random.nextInt(adress.length - 1)];
		if (random.nextInt(3) == 0) {
			return adressname + " street";
		} else {
			return adressname + " avenue";
		}
	}

	public String generateRandomEmailDomain() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "@gmail.com";
		} else {
			return "@mail.ru";
		}
	}

	public String generateRandomPhoneMobileNumber() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "+7921" + generateRandomSetNumber(7);
		} else if (rnd.nextInt(3) == 2) {
			return "+7962" + generateRandomSetNumber(7);
		} else {
			return "+7911" + generateRandomSetNumber(7);
		}
	}

	public String generateRandomYear() {
		Random rnd = new Random();
		return String.valueOf(1964 + rnd.nextInt(50));
	}

	public String generateRandomSetNumber(int length) {
		Random ran = new Random();
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int nextNumber = ran.nextInt(10);
			if (nextNumber == 0) {
				nextNumber = 1;
			}
			buf.append(nextNumber);
		}
		return buf.toString();
	}

}
