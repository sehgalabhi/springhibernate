package com.framework.hibernate.entity;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetailsValueTypeColumnOverride {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USER_NAME")
	private String userName;
	@Temporal(TemporalType.DATE)
	private Date joinedDate;

	@Embedded
	private Address officeAddress;
	
	@Embedded
	@AttributeOverrides(value={
			@AttributeOverride(name="street", column=@Column(name="HOME_STREET_NAME")),
			@AttributeOverride(name="city", column=@Column(name="HOME_CITY_NAME")),
			@AttributeOverride(name="state", column=@Column(name="HOME_STATE_NAME")),
			@AttributeOverride(name="zipcode", column=@Column(name="HOME_ZIPCODE_NAME"))		
			
	})
	private Address homeAddress;

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	@Temporal(TemporalType.TIME)
	private Date joinedTime;

	public Date getJoinedTime() {
		return joinedTime;
	}

	public void setJoinedTime(Date joinedTime) {
		this.joinedTime = joinedTime;
	}

	@Transient
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String toString() {
		return this.getUserName() + "-->" + this.getDescription() + "-->" + this.getJoinedTime();
	}
}
