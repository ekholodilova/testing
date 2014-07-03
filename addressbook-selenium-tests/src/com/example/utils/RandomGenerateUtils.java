package com.example.utils;

import java.util.Random;
import com.example.utils.RandomGenerateUtils;

public class RandomGenerateUtils {
	
	public static String generateRandomString() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "";
		} else {
			return "test" + rnd.nextInt();
		}
	}
	
	public static String[] names = new String[] { "John", "Ann", "Kieth",
		"Jens", "Aric", "Boas", "David", "Martin", "Linda", "Leon" };
	public static String[] lastnames = new String[] { "Smith", "Abstract",
		"Bull", "Fat", "Thin", "Uils", "Braun", "Lind", "Lame", "Telemann" };
	public static String[] months = new String[] { "January", "February",
		"March", "April", "May", "June", "July", "August", "September",
		"October", "November", "December" };
	public static String[] adress = new String[] { "Rose", "Direct", "Dance",
		"Coco", "Big", "Little", "Flower", "Shot", "Center", "Student",
		"Varna", "Fish" };
	
	public static String generateRandomFirstNameString() {
		Random random = new Random();
		return names[random.nextInt(names.length - 1)];
	}

	public static  String generateRandomLastnameString() {
		Random random = new Random();
		return lastnames[random.nextInt(lastnames.length - 1)];
	}

	public static String generateRandomMonthString() {
		Random random = new Random();
		return months[random.nextInt(months.length - 1)];
	}

	public static String generateRandomAdress() {
		Random random = new Random();
		String adressname = adress[random.nextInt(adress.length - 1)];
		if (random.nextInt(3) == 0) {
			return adressname + " street";
		} else {
			return adressname + " avenue";
		}
	}

	public static String generateRandomEmailDomain() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "@gmail.com";
		} else {
			return "@mail.ru";
		}
	}

	public static String generateRandomPhoneMobileNumber() {
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0) {
			return "+7921" + generateRandomSetNumber(7);
		} else if (rnd.nextInt(3) == 2) {
			return "+7962" + generateRandomSetNumber(7);
		} else {
			return "+7911" + generateRandomSetNumber(7);
		}
	}

	public static String generateRandomYear() {
		Random rnd = new Random();
		return String.valueOf(1964 + rnd.nextInt(50));
	}

	public static String generateRandomSetNumber(int length) {
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
