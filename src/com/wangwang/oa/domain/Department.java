package com.wangwang.oa.domain;

import java.util.Set;

public class Department {
	private Integer id;
	private String name;
	private Set<User> users;
	private Department parent;
	private Set<Department> chidrent;
	private String description;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public Department getParent() {
		return parent;
	}

	public Set<Department> getChidrent() {
		return chidrent;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public void setParent(Department parent) {
		this.parent = parent;
	}

	public void setChidrent(Set<Department> chidrent) {
		this.chidrent = chidrent;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
