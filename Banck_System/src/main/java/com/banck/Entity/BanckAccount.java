package com.banck.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BanckAccount {
	@Id
	 private int accountNmae;
	 private String accountName;
	 private double accountBalance;
	 
	 
	  public BanckAccount() {
		// TODO Auto-generated constructor stub
	}


	public BanckAccount(int accountNmae, String accountName, double accountBalance) {
		super();
		this.accountNmae = accountNmae;
		this.accountName = accountName;
		this.accountBalance = accountBalance;
	}


	public int getAccountNmae() {
		return accountNmae;
	}


	public void setAccountNmae(int accountNmae) {
		this.accountNmae = accountNmae;
	}


	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public double getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}


	@Override
	public String toString() {
		return "BanckAccount [accountNmae=" + accountNmae + ", accountName=" + accountName + ", accountBalance="
				+ accountBalance + "]";
	}
	
	
	  

}
