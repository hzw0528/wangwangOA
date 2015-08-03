package com.wangwang.oa.dao;

import java.util.List;

import com.wangwang.oa.base.BaseDao;
import com.wangwang.oa.domain.Department;

public interface DepartmentDao extends BaseDao<Department> {
   List<Department> getAllByParents(Integer parentId);
   List<Department> getTopDepartments();
}
