package com.spring.boot.dao.security;


import com.spring.boot.entity.security.SysPermission;

import java.util.List;
import java.util.Map;

/**
 * @author zengfeiyue
 */
public interface SysPermissionMapper {

    List<SysPermission> getByMap(Map<String, Object> map);

    SysPermission getById(Integer id);

    Integer create(SysPermission sysPermission);

    int update(SysPermission sysPermission);

    List<SysPermission> getByUserId(Integer userId);

}