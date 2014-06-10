package com.example.tests;

import org.openqa.selenium.WebElement;

public class ContactData implements Comparable<ContactData>{
	public String firstname;
	public String lastname;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String newgroup;
	public String address2;
	public String phone2;
    public static final String SPACE = " ";
    public static final String NO_SPACE = "";

	public ContactData() {
	}
	
	public ContactData(String firstname, String lastname, String address,String home,String mobile,String work,String email,String email2,String bday,String bmonth,String byear,String newgroup,String address2,String phone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.newgroup = newgroup;
		this.address2 = address2;
		this.phone2 =phone2;
		}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (!other.getStringViewForCompare().equalsIgnoreCase(this.getStringViewForCompare()))
			return false;
		return true;
	}
	
	
	protected String getStringViewForCompare() {
		StringBuffer sb = new StringBuffer("");
		sb.append(this.firstname);
		sb.append(",");
		sb.append(this.lastname);
		sb.append(",");
		sb.append(this.email);
		sb.append(",");
		if (this.home != null) {
			sb.append(this.home.replace(SPACE, NO_SPACE));
		} else {
			sb.append(this.home);
		}
			
		return sb.toString();  
	}

	@Override
	public String toString() {
		return "GroupData [firstname=" + firstname + ", lastname=" + lastname + ", email="
				+ email + ", home=" + home + "]";
	}

	@Override
	public int compareTo(ContactData other) {
		return this.getStringViewForCompare().toLowerCase().compareTo(other.getStringViewForCompare().toLowerCase());
	}
}


