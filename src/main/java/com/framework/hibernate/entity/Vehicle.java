package com.framework.hibernate.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
@NamedQueries(value={@NamedQuery(name="Vehicle.byID", query="from Vehicle where vehicleid = ?")})
@NamedNativeQuery(name="Vehicle.byName", query= "select * from Vehicle where vehicleid = ?", resultClass=Vehicle.class)
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)

public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicleId;

	@ManyToMany(mappedBy="vehicles")
	private List<UserDetails> userList;

	public List<UserDetails> getUserList() {
		return userList;
	}

	public void setUserList(List<UserDetails> userList) {
		this.userList = userList;
	}

	private String vehicleName;

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.vehicleName;
	}

}
