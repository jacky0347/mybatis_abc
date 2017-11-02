package com.jacky.mybatis.dao;

import com.jacky.mybatis.beans.Role;

/**
 * Created by jacky on 2017/10/23.
 */
public interface RoleMapper {
    public Role getRole(Long id);
    public void insertRole(Role role);
    public void deleteRole(Long id);
}
