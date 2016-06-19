package com.framework.hibernate.entity;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicle{
	private String SteeringWheel;

	public String getSteeringHandle() {
		return SteeringWheel;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringWheel = steeringHandle;
	}
}
