package com.spring.boot.mapper.security;


import com.spring.boot.moduls.security.SysPermission;

import java.util.List;
import java.util.Map;

public interface SysPermissionMapper {

    List<SysPermission> getByMap(Map<String, Object> map);

    SysPermission getById(Integer id);

    Integer create(SysPermission sysPermission);

    int update(SysPermission sysPermission);

    List<SysPermission> getByUserId(Integer userId);

}