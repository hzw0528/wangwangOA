package com.wangwang.oa.controller;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.wangwang.oa.domain.Role;
import com.wangwang.oa.domain.extension.RoleExt;
import com.wangwang.oa.service.RoleService;

@Controller
@Scope("prototype")
// 设置为多例
public class RoleAction implements ModelDriven<Role> {
	private String type;
	//private Role model=new Role();
	private Role model=new Role();
	//private Integer id;
	@Resource
	private RoleService roleService;


	/**
	 * 列表
	 * 
	 * @return
	 */
	public String list() {
		List<Role> roleList=roleService.getAlls();
		//绑定数据给VIEW调用
		ActionContext.getContext().put("roleList",roleList);
		return "list";
	}

	/**
	 * 新增页面UI
	 * 
	 * @return
	 */
	public String addUI() {
		return "saveUI";
	}

	/**
	 * 新增保存
	 * 
	 * @return
	 */
	public String add() {
      
		if(model!=null) roleService.addRole(model);
		
		
		return "toList";
	}

	// ==================================================================
	/**
	 * 更新UI
	 * 
	 * @return
	 */
	public String updateUI() {
		this.model=roleService.getRoleById(model.getId());
		return "saveUI";
	}

	/***
	 * 更新操作
	 * 
	 * @return
	 */
	public String update() {
		if(model!=null)
		roleService.modifyRole(model);
		
		return "toList";

	}

	// ==================================================================
	/***
	 * 删除操作
	 * 
	 * @return
	 */
	public String delete() {
		roleService.deleteById(model.getId());
		return "toList";
	}
	//==================================================================
	/*public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}*/
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@Override
	public Role getModel() {
		return model;
	}
	
	
}
