package com.wangwang.oa.service;



import java.util.List;

import com.wangwang.oa.domain.Role;
import com.wangwang.oa.domain.extension.RoleExt;

public interface RoleService {
  public void addRole(Role role);
  public void modifyRole(Role role);
  public List<Role> getAlls();
  public void deleteById(Integer id);
  public Role getRoleById(Integer id);
  
}
