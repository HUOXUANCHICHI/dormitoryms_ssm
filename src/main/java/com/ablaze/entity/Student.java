package com.ablaze.entity;

import lombok.Data;

/**
 * @Author: ablaze
 * @Date: 2022/09/09/18:02
 */

@Data
public class Student {
    /**
     * 学生id
     */
    private Integer id;
    /**
     * 学号
     */
    private String number;
    /**
     * 学生姓名
     */
    private String name;

    private String gender;
    /**
     * 宿舍id
     */
    private Integer dormitoryId;
    /**
     * 原宿舍id
     */
    private Integer oldDormitoryId;
    /**
     * 宿舍名称
     */
    private String dormitoryName;
    /**
     * 入住状态
     */
    private String state;
    /**
     * 时间
     */
    private String createDate;
}
