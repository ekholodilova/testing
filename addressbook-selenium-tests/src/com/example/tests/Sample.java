package com.example.tests;

public class Sample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    String a = "test";
    String t = "    +7 (916) 123-45-67    ";
    t = t.trim();
    t = t.replaceAll("[ ()\\-]","");
    String b = "test    test    test";
    String[] list = b.split("\\s+");
    
    System.out.println(b.contains(a));
    //System.out.println(b.indexOf(a));
    System.out.println(list.length);
    //System.out.println(list[0]);
    //System.out.println(list[1]);
    //System.out.println(b.matches("(\\w+\\s+)+"));
    //System.out.println(t.matches("\\+\\d+\\s*\\(\\d+\\)\\s*[\\d\\-]+"));  //check for t before replace
    System.out.println(t);
    System.out.println(t.matches("\\+\\d+"));  
	}

}
