package com.spring.boot.dao.security;


import com.spring.boot.entity.security.SysUser;

import java.util.List;
import java.util.Map;

public interface SysUserMapper {

	List<SysUser> getByMap(Map<String, Object> map);
	SysUser getById(Integer id);
	Integer create(SysUser sysUser);
	int update(SysUser sysUser);
	SysUser getByUserName(String userName);
}