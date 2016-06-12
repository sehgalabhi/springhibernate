package com.framework.hibernate.entity;

public class Department {

	private Long id;

	private Long managerID;

	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getManagerID() {
		return managerID;
	}

	public void setManagerID(Long managerID) {
		this.managerID = managerID;
	}

	public Long getLocationID() {
		return locationID;
	}

	public void setLocationID(Long locationID) {
		this.locationID = locationID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	private Long locationID;

	private String departmentName;
	
	@Override
	public String toString(){
		return this.departmentName+ this.id+this.locationID+this.managerID;
	}

}
