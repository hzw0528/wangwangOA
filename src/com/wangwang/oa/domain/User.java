package com.wangwang.oa.domain;

import java.util.Set;

public class User {
	private Integer id;
	private String loginName;
	private String password;
	private String name;
	private String sex;
	private String phoneNumber;
	private String email;
	private Department department;
	private Set<Role> roles;
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public Department getDepartment() {
		return department;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public String getDescription() {
		return description;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
