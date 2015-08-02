package com.wangwang.oa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.wangwang.oa.domain.Department;
import com.wangwang.oa.service.DepartmentService;

@Controller
@Scope("prototype")
public class DepartmentAction {

	@Resource
	private DepartmentService departmentService;

	private Department department;
	private Integer id;
	/**
	 * 列表
	 * 
	 * @return
	 */
	public String list() {

		List<Department> depart_list = departmentService.getAllDepartments();
		ActionContext.getContext().put("depart_list", depart_list);
		return "list";
	}

	/**
	 * 新增页面
	 * 
	 * @return
	 */
	public String addUI() {
		return "saveUI";
	}

	/**
	 * 保存新增的内容
	 * 
	 * @return
	 */
	public String add() {
		departmentService.addDepartment(department);
		return "toList";
	}

	/**
	 * 保存UI
	 * 
	 * @return
	 */
	public String updateUI() {
		department=departmentService.getDepartmentById(getId());
		System.out.println(department);
		return "saveUI";
	}

	/**
	 * 保存数据
	 * 
	 * @return
	 */
	public String update() {
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

}
