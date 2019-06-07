package com.wayne.race.pojo;

import java.util.Date;

public class Department {

	private Integer d_id;
	private String departmentName;
	private Date create_date;


	public Integer getD_id() {
		return d_id;
	}

	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	@Override
	public String toString() {
		return "Department{" +
				"d_id=" + d_id +
				", departmentName='" + departmentName + '\'' +
				", create_date=" + create_date +
				'}';
	}
}
