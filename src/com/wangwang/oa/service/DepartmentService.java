package com.wangwang.oa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wangwang.oa.domain.Department;


public interface DepartmentService {
	/**
	 * 获得全部的部门
	 * 
	 * @return
	 */
	List<Department> getAllDepartments();

	/**
	 * 新增一个部门
	 * 
	 * @param department
	 */
	void addDepartment(Department department);

	/**
	 * 修改一个部门
	 * 
	 * @param department
	 */
	void modifyDepartment(Department department);

	/**
	 * 删除一个部门
	 * 
	 * @param id
	 */
	void deleteDepartmentById(Integer id);

	/**
	 * 根据ID获得部门信息
	 * 
	 * @param id
	 * @return
	 */
	Department getDepartmentById(Integer id);
}
