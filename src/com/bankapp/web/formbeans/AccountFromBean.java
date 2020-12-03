package com.bankapp.web.formbeans;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.bankapp.model.entities.AccountStatusType;
import com.bankapp.model.entities.AccountType;

public class AccountFromBean {
	@NotNull(message="account id can not be null")
   private Integer accountId;
	@NotNull(message="name can not be null")
	private String name;
	@NotNull(message="balance can not be null")
	private Double balance;
	@NotNull(message="address can not be null")
	private String address;
	@NotNull(message="phone can not be null")
	private String phone;
	@NotNull(message="email can not be null")
	@Email
	private String email;
	@NotNull(message="aadharcard can not be null")
	private String aadharNumber;
	private String panNumber;
	@NotNull(message="accounttype can not be null")
	private AccountType accountType;
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public AccountFromBean() {
		
	}
	
	
	
}
