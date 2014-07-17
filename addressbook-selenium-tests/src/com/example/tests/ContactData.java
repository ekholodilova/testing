package com.example.tests;

public class ContactData implements Comparable<ContactData> {
	private String id;
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
	private String email1;
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
		this.email1 = email;
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
		sb.append(this.lastname);
		sb.append(",");
		sb.append(this.firstname);
		sb.append(",");
		sb.append(this.email1);
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
				+ ", email=" + email1 + ", home=" + home + "]";
	}

	@Override
	public int compareTo(ContactData other) {
		return this.getStringViewForCompare().toLowerCase()
				.compareTo(other.getStringViewForCompare().toLowerCase());
	}
	
	public ContactData withId(String id) {
		this.id = id;
		return this;
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

	public ContactData withEmail1(String anEmail) {
		if (anEmail != null) {
			this.email1 = anEmail;
		} else {
			this.email1 = createEmail1();
		}
		return this;
	}
	
	public ContactData withEmail2(String anEmail) {
		if (anEmail != null) {
			this.email2 = anEmail;
		} else {
			this.email2 = createEmail2();
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
	
	public String createEmail1() {
		return  this.firstname + "." + this.lastname +"" + this.emaildoman1;
	}
	
	public String getEmail1() {
		return email1;
	}

	public String getEmail2() {
		return email2;
	}

	public String createEmail2() {
		return  this.firstname + "." + this.lastname +"" + this.emaildoman2;
	}

	public void trimHome() {
		home = home.trim();
		if (home.indexOf(ContactData.SPACE) != -1) {
			home.replace(ContactData.SPACE, ContactData.NO_SPACE);
		}
	}

	public String getId() {
		return id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setWork(String work) {
		this.work = work;
	}


	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public void setBday(String bday) {
		this.bday = bday;
	}

	public void setBmonth(String bmonth) {
		this.bmonth = bmonth;
	}

	public void setByear(String byear) {
		this.byear = byear;
	}

	public void setNewgroup(String newgroup) {
		this.newgroup = newgroup;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public void setEmaildoman1(String emaildoman1) {
		this.emaildoman1 = emaildoman1;
	}

	public void setEmaildoman2(String emaildoman2) {
		this.emaildoman2 = emaildoman2;
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
	
	public String getEmailDomain1() {
		return emaildoman1;
	}
	
	public String getEmailDomain2() {
		return emaildoman2;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}
	
}
