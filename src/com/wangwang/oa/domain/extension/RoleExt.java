package com.wangwang.oa.domain.extension;

import com.wangwang.oa.domain.Role;

/**
 * 角色扩展类
 * 
 * @author huangzhiwang
 * 
 */
public class RoleExt extends Role {
	private String url;
    private String type;
    
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
