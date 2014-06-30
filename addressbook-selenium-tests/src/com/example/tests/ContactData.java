package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String firstname;
	private String lastname;
	private String address;
	private String home;
	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	private String mobile;
	private String work;
	private String email;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	public String newgroup;
	private String address2;
	private String phone2;
	private String emaildoman1;
	private String emaildoman2;
	public static final String SPACE = " ";
	public static final String NO_SPACE = "";

	public ContactData() {
	}

	public ContactData(String firstname, String lastname, String address,
			String home, String mobile, String work, String email,
			String email2, String bday, String bmonth, String byear,
			String newgroup, String address2, String phone2) {
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
		this.phone2 = phone2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (!other.getStringViewForCompare().equalsIgnoreCase(
				this.getStringViewForCompare()))
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
		return "GroupData [firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", home=" + home + "]";
	}

	@Override
	public int compareTo(ContactData other) {
		return this.getStringViewForCompare().toLowerCase()
				.compareTo(other.getStringViewForCompare().toLowerCase());
	}
	
	public ContactData withFirstName(String firstname) {
		this.firstname = firstname;
		return this;
	}

	public ContactData withLastName(String lastname) {
		this.lastname = lastname;
		return this;
	}

	public ContactData withAddress(String adress) {
		address = adress;
		return this;
	}

	public ContactData withHome(String home) {
		this.home = home;
		return this;
	}

	public ContactData withMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public ContactData withWork(String work) {
		this.work = work;
		return this;
	}
	
	public ContactData withEmailDomain1(String emaildoman) {
		this.emaildoman1 = emaildoman;
		return this;
	}
	
	public ContactData withEmailDomain2(String emaildoman) {
		this.emaildoman2 = emaildoman;
		return this;
	}

	public ContactData withEmail(String anEmail) {
		if (anEmail != null) {
			this.email = anEmail;
		} else {
			this.email = getEmail1();
		}
		return this;
	}
	
	public ContactData withEmail2(String anEmail) {
		if (anEmail != null) {
			this.email2 = anEmail;
		} else {
			this.email2 = getEmail2();
		}
		return this;
	}

	public ContactData withBday(String bday) {
		this.bday = bday;
		return this;
	}

	public ContactData withBmonth(String bmonth) {
		this.bmonth = bmonth;
		return this;
	}

	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		return this;
	}

	public ContactData withByear(String byear) {
		this.byear = byear;
		return this;
	}

	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		return this;
	}
	
	public String getEmail1() {
		return  this.firstname + "." + this.lastname +"" + this.emaildoman1;
	}
	
	public String getEmail2() {
		return  this.firstname + "." + this.lastname +"" + this.emaildoman2;
	}

	public void trimHome() {
		home = home.trim();
		if (home.indexOf(ContactData.SPACE) != -1) {
			home.replace(ContactData.SPACE, ContactData.NO_SPACE);
		}
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getMobile() {
		return mobile;
	}

	public String getWork() {
		return work;
	}

	public String getBday() {
		return bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public String getByear() {
		return byear;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}
	
	
}
