package com.ablaze.entity;

import lombok.Data;

/**
 * @Author: ablaze
 * @Date: 2022/09/14/17:26
 */
@Data
public class Building {

    private Integer id;
    private String name;
    private String introduction;
    private Integer adminId;
    private String adminName;

}
