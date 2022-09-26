package com.ablaze.mapper;

import com.ablaze.entity.SystemAdmin;

/**
 * @Author: ablaze
 * @Date: 2022/09/08/12:59
 */
public interface SystemAdminMapper {
    /**
     * 系统管理员根据用户名查找
     * @param username
     * @return
     */
    SystemAdmin findByUsername(String username);
}
