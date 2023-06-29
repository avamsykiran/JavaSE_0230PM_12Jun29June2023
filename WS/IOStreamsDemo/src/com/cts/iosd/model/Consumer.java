package com.cts.iosd.model;

import java.time.LocalDate;

public class Consumer {
	private String fullName;
	private LocalDate dateOfBirth;
	private String mobile;
	private String mailId;;
	private String baseLocation;
	
	public Consumer() {
		// TODO Auto-generated constructor stub
	}

	public Consumer(String fullName, LocalDate dateOfBirth, String mobile, String mailId, String baseLocation) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.mobile = mobile;
		this.mailId = mailId;
		this.baseLocation = baseLocation;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getBaseLocation() {
		return baseLocation;
	}

	public void setBaseLocation(String baseLocation) {
		this.baseLocation = baseLocation;
	}

	@Override
	public String toString() {
		return "Consumer [fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", mobile=" + mobile + ", mailId="
				+ mailId + ", baseLocation=" + baseLocation + "]";
	}
	
	
	
}
