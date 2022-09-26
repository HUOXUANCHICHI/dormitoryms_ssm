package com.ablaze.entity;

import lombok.Data;

/**
 * @Author: ablaze
 * @Date: 2022/09/08/15:51
 */
@Data
public class DormitoryAdmin {
    /**
     * 宿舍管理员id
     */
    private Integer id;
    /**
     * 宿舍管理员名称
     */
    private String username;
    private String password;
    /**
     * 宿舍管理员昵称
     */
    private String name;
    private String gender;
    private String telephone;
}
