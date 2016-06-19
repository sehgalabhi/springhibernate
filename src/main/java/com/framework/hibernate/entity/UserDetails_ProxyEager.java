package com.framework.hibernate.entity;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails_ProxyEager {

	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="USER_ID")
	private int userId;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS",
		joinColumns=@JoinColumn(name="USER_ID")
			)
	
	private List<Address> listOfAddresses;
	
	
	public List<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(List<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	
	@Temporal(TemporalType.TIME)
	private Date joinedTime;
	
	public Date getJoinedTime() {
		return joinedTime;
	}
	public void setJoinedTime(Date joinedTime) {
		this.joinedTime = joinedTime;
	}
	private String address;
	
	@Transient
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
	public String toString(){
		return this.getUserName() + "-->" + this.getDescription()  + "-->" + this.getJoinedTime();
	}
}
