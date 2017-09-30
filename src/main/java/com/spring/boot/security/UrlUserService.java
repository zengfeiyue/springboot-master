package com.spring.boot.security;

import com.spring.boot.mapper.security.SysPermissionMapper;
import com.spring.boot.mapper.security.SysUserMapper;
import com.spring.boot.moduls.security.SysPermission;
import com.spring.boot.moduls.security.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengfeiyue on 17/2/7.
 */
@Service
public class UrlUserService implements UserDetailsService {
    @Autowired
    SysUserMapper userMapper;
    @Autowired
    SysPermissionMapper permissionMapper;
    @Override
    public UserDetails loadUserByUsername(String userName) { //重写loadUserByUsername 方法获得 userdetails 类型用户
        System.err.println(userMapper);
        SysUser sysUser = userMapper.getByUserName(userName);
        if (sysUser != null) {
            List<SysPermission> sysPermissions = permissionMapper.getByUserId(sysUser.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            for (SysPermission sysPermission : sysPermissions) {
                if (sysPermission != null && sysPermission.getName()!=null) {
                    GrantedAuthority grantedAuthority = new UrlGrantedAuthority(sysPermission.getPermissionUrl(), sysPermission.getMethod());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            sysUser.setGrantedAuthorities(grantedAuthorities);
            return sysUser;
        } else {
            throw new UsernameNotFoundException("admin: " + userName + " do not exist!");
        }
    }
}