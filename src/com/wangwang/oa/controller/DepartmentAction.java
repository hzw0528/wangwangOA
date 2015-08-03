package com.wangwang.oa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wangwang.oa.domain.Department;
import com.wangwang.oa.service.DepartmentService;
import com.wangwang.oa.util.DepartmentUtils;

@Controller
@Scope("prototype")
public class DepartmentAction {

	@Resource
	private DepartmentService departmentService;

	private Department department;
	private Integer id;
	private Integer parentId;

	/**
	 * 列表
	 * 
	 * @return
	 */
	public String list() {

		if (parentId == null) {
			// 没有传入parentid时候获得全部的部门
			List<Department> depart_list = departmentService
					.getAllDepartments();
			ActionContext.getContext().put("depart_list", depart_list);
		} else {
			// 根据parentid获得部门信息
			List<Department> depart_list = departmentService
					.getDepartmentsByParentId(parentId);
			ActionContext.getContext().put("depart_list", depart_list);
			// 获得父节点的父节点
			Department depart_parent = departmentService
					.getDepartmentById(parentId);
			ActionContext.getContext().put("depart_parent", depart_parent);
		}
		return "list";
	}

	/**
	 * 新增页面
	 * 
	 * @return
	 */
	public String addUI() {
		// 获得所有的部门
		// List<Department> departments
		// =DepartmentUtils.getAllDepartments(departmentService.getTopDepartments());
		// //departmentService.getAllDepartments();
		List<Department> topList = departmentService.getTopDepartments();
		List<Department> departments = DepartmentUtils
				.getAllDepartments(topList,departmentService);
		ActionContext.getContext().put("departments", departments);
		return "saveUI";
	}

	/**
	 * 保存新增的内容
	 * 
	 * @return
	 */
	public String add() {

		Department parent = departmentService.getDepartmentById(parentId);
		department.setParent(parent);
		departmentService.addDepartment(department);
		return "toList";
	}

	/**
	 * 保存UI
	 * 
	 * @return
	 */
	public String updateUI() {
		// 获得所有的部门
		// List<Department> departments = departmentService.getAllDepartments();
		List<Department> topList = departmentService.getTopDepartments();
		List<Department> departments = DepartmentUtils
				.getAllDepartments(topList,departmentService);
		System.out.println("Children count:"
				+ topList.get(0).getChidrent().size());
		ActionContext.getContext().put("departments", departments);
		department = departmentService.getDepartmentById(getId());

		return "saveUI";
	}

	/**
	 * 保存数据
	 * 
	 * @return
	 */
	public String update() {
		Department parent = departmentService.getDepartmentById(parentId);
		department.setParent(parent);
		departmentService.modifyDepartment(department);
		return "toList";
	}

	/**
	 * 删除数据
	 * 
	 * @return
	 */
	public String delete() {
		departmentService.deleteDepartmentById(id);
		return "toList";
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
