package com.spring.boot.service;

import com.spring.boot.dao.security.SysUserMapper;
import com.spring.boot.entity.security.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zengfeiyue
 */
@Service
public class SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	public SysUser getById(Integer id) {
		SysUser user = sysUserMapper.getById(id);
		return user;
	}
	

}