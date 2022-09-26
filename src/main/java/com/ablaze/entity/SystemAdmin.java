package com.ablaze.entity;

import lombok.Data;

/**
 * @Author: ablaze
 * @Date: 2022/09/08/12:50
 */
@Data
public class SystemAdmin {
    /**
     * 系统管理员id
     */
    private Integer id;
    /**
     * 系统管理员用户名
     */
    private String username;
    private String password;
    /**
     * 系统管理员真是姓名
     */
    private String name;
    private String telephone;
}
