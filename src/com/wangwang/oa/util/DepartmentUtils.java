package com.wangwang.oa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;

import com.wangwang.oa.domain.Department;
import com.wangwang.oa.service.DepartmentService;

public class DepartmentUtils {

	private DepartmentService departmentService;
	

	public static List<Department> getAllDepartments(List<Department> topList,
			DepartmentService departmentService) {
		ArrayList<Department> list = new ArrayList<Department>();
		walkDepartmentList(topList, "┣", list,departmentService);
		return list;
	}

	private static void walkDepartmentList(Collection<Department> toList,
			String prefix, List<Department> newList,DepartmentService departmentService) {

		// 遍历集合中元素
		for (Department department : toList) {
			// 顶端
			Department top = new Department();
			BeanUtils.copyProperties(department, top);
			top.setName(prefix + top.getName());
			// 将新修改的对象添加到集合中
			newList.add(top);

			// 子
			walkDepartmentList(
					departmentService.getDepartmentsByParentId(department
							.getId()), "　 " + prefix, newList,departmentService);

		}
	}
}
