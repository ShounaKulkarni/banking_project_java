package com.zensar;

public class BankBean {

	private int accNo;
	private String username;
	private String password;
	private int amount;
	private String address;
	private int phoneNo;
	public BankBean(int accNo, String username, String password, int amount, String address, int phoneNo) {
		super();
		this.accNo = accNo;
		this.username = username;
		this.password = password;
		this.amount = amount;
		this.address = address;
		this.phoneNo = phoneNo;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Override
	public String toString() {
		return "BankBean [accNo=" + accNo + ", username=" + username + ", password=" + password + ", amount=" + amount
				+ ", address=" + address + ", phoneNo=" + phoneNo + "]";
	}
	//rahul
	public BankBean(int amount, int accNo) {
		super();
		this.amount = amount;
		this.accNo = accNo;
	}

 
}
